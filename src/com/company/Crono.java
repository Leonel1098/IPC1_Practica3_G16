package com.company;

public class Crono extends Thread{
    public static volatile boolean ejecutar = true;

    public void detener(){
        ejecutar = false;
    }

    public void run(){
        Integer minutos = 0, segundos = 0, milesimas = 0;
        String min ="",seg ="", mil ="";
        try {
            while (ejecutar){
                Thread.sleep(4);
                milesimas +=4;
                if (milesimas == 1000){
                    milesimas = 0;
                    segundos += 1;
                    if (segundos == 60){
                        segundos = 0;
                        minutos++;
                    }
                }

                if (minutos < 10){
                    min="0" + minutos;
                }else{
                    min = minutos.toString();
                }

                if (segundos < 10){
                    seg = "0" + segundos;
                }else{
                    seg = segundos.toString();
                }

                if(milesimas < 10){
                    mil = "00" + milesimas;
                }else if (milesimas<100){
                    mil = "0" + milesimas;
                }else {
                    mil = milesimas.toString();
                }

                grafica.time.setText(min + ":" +seg +":" + mil);
            }
        }catch (InterruptedException ae){

        }
    }

}
