package br.com.lucio.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.sound.midi.Soundbank;

public class NovaApiDatas {
    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        
        LocalDate dataAleatoria = LocalDate.of(2040, Month.APRIL, 5);
        
        int anos = dataAleatoria.getYear() - hoje.getYear();
        
        System.out.println("Faltam " + anos + " ano(s) para a dataAleatoria");
  
        Period periodo = Period.between(hoje, dataAleatoria);
        
        System.out.println("Faltam " + periodo.getYears() + "ano(s), " +
                            periodo.getMonths() + " meses e " +
                            periodo.getDays()  + " dia(s) para a data aleatoria");
        
        LocalDate dataMais10Anos = dataAleatoria.plusYears(10);
        System.out.println("Data + 10 anos = " + dataMais10Anos);
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println(formatador.format(dataAleatoria));
        System.out.println(formatador.format(dataMais10Anos));
        
        DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        System.out.println(formatadorHoras.format(LocalDateTime.now()));
        
        
        DateTimeFormatter formatAnoMes = DateTimeFormatter.ofPattern("MM/yyyy");
        
        YearMonth anoMes = YearMonth.from(dataAleatoria);
        System.out.println(formatAnoMes.format(anoMes));
        
    }
}
