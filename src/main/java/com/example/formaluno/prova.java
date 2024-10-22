package com.example.formaluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "resultadoProva", value = "/resultadoProva")
public class prova extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PrintWriter out = response.getWriter();
            Double nota = 0.00;
            Integer acertos = 0;
            String aluno = request.getParameter("aluno");

            // Questão 1: Animais mamíferos
            String[] mamiferosSelecionados = request.getParameterValues("mamiferos");
            List<String> mamiferosCorretos = Arrays.asList("golfinho", "onca", "mico");

            if (mamiferosSelecionados != null) {
                int acertosAnimais = 0;

                for (String mamiferos : mamiferosSelecionados) {
                    if (mamiferosCorretos.contains(mamiferos)) {
                        acertosAnimais++;
                    }

                }
                acertos =  acertosAnimais == 3 ? acertos + 1 : acertos ;
                nota += (acertosAnimais / (double) mamiferosCorretos.size()) * 2;
            } else {
                out.println("<h1>faltou selecionar um animal </h1>");
                out.println("<a href='index.html'> Voltar ao questionário </a>");
            }

            // Questão 2: Itens que são software
            String[] softwareSelecionados = request.getParameterValues("software");
            List<String> softwaresCorretos = Arrays.asList("sistema_operacional", "planilha_eletronica", "compilador");

            if (softwareSelecionados != null) {
                Integer acertosSoftware = 0;
                for (String software : softwareSelecionados) {
                    if (softwaresCorretos.contains(software)) {
                        acertosSoftware++;
                    }
                }
                acertos =  acertosSoftware == 3 ? acertos + 1 : acertos ;
                nota += (acertosSoftware / (double) softwaresCorretos.size()) * 2;
            } else {
                out.println("<h1>faltou selecionar um sistema operacional </h1>");
                out.println("<a href='index.html'> Voltar ao questionário </a>");
            }
            ;
//        if (softwareSelecionados != null && softwaresCorretos.containsAll(Arrays.asList(softwareSelecionados))) {
//            acertos+= 2;
//        }

            // Questão 3: Data da Primeira Guerra Mundial
            String dataPrimeiraGuerra = request.getParameter("data_primeira_guerra");
            if ("1914-07-28".equals(dataPrimeiraGuerra)) {
                nota += 2;
                acertos++;
            }
            ;

            // Questão 4: Metal líquido em temperatura ambiente
            String metal = request.getParameter("metal");
            if ("mercurio".equals(metal)) {
                nota += 2;
                acertos++;
            }
            ;

            // Questão 5: Resultado da expressão 2 + 4 * 5 - 3
            String resultadoExpressao = request.getParameter("resultado_expressao");
            if ("19".equals(resultadoExpressao)) {
                nota += 2;
                acertos++;
            };

            // Calcular a nota (5 questões, cada acerto vale 2 pontos)
            DecimalFormat df = new DecimalFormat("#.00");
            String notaFormatada = df.format(nota);
            String resultado = nota > 6 ? "Aprovado" : "Reprovado";

            // Resposta HTML

            request.setAttribute("aluno",aluno);
            request.setAttribute("acertos",acertos);
            request.setAttribute("nota",notaFormatada);
            request.setAttribute("resultado",resultado);
            request.getRequestDispatcher("resultado.jsp").forward(request,response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        };



    }
}




