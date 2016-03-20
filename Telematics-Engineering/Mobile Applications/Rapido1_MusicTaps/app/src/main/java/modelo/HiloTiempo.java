package modelo;

import android.os.AsyncTask;
import android.widget.TextView;

public class HiloTiempo extends AsyncTask<Void,Float,Boolean> {

    private TextView tiempo;
    private int contador;
    private double time;
    String hora;
    private Juego modelo;

    public HiloTiempo(TextView t, Juego mo){

        tiempo = t;
        modelo = mo;
        contador = 0;
        hora = "";
    }
    @Override
    protected Boolean doInBackground(Void... params) {

        double inicio = System.currentTimeMillis();

        while(modelo.isTiempoActivo()){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = System.currentTimeMillis()-inicio;


            int secs = (int) (time / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (time % 1000);
            hora = "" + mins + ":" + String.format("%02d", secs) + ":" + String.format("%03d", milliseconds);

            modelo.getUsuarios().get(0).setTiempo(hora);
            publishProgress();
        }

        return false;
    }


    @Override
    protected void onProgressUpdate(Float... values) {
        tiempo.setText(hora);
    }
}
