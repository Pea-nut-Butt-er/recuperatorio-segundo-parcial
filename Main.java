import exceptions.excesoDeJugadoresException;
import model.Jugador;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import service.JugadorService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws JSONException, IOException, excesoDeJugadoresException {

        try {
            //se pasa el json a un JSONArray y se crea el service
            JSONArray arreglo = new JSONArray(JsonUtiles.leer("jugadores"));
            JugadorService jugadorService = new JugadorService();

            System.out.println(arreglo.length());

            //se pasa el JSONArray a los treemap

            ArrayList<JSONObject> aux1 = new ArrayList<>();
            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject jsonObject = arreglo.getJSONObject(i);

                for (int j = 0; j < arreglo.length(); j++) {
                    JSONObject jsonObject2 = arreglo.getJSONObject(j);
                    if(jsonObject.getString("eyeColor").equals(jsonObject2.getString("eyeColor"))) {
                        aux1.add(jsonObject);
                    }
                }
                jugadorService.getColores().put(jsonObject.getString("eyeColor"), aux1);
            }
            ArrayList<JSONObject> aux2 = new ArrayList<>();
            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject jsonObject = arreglo.getJSONObject(i);
                String position = jsonObject.getString("position");
                for (int j = 0; j < arreglo.length(); j++) {
                    JSONObject jsonObject2 = arreglo.getJSONObject(j);
                    if(position.equals(jsonObject2.getString("position"))) {
                        aux2.add(jsonObject);
                    }
                }
                jugadorService.getPosiciones().put(position, aux1);
            }

            //se muestran los treemap

            System.out.println(jugadorService.getColores().toString());
            System.out.println(jugadorService.getPosiciones().toString());

            //se llama al metodo que
            Integer cantJugadoresOjosVerdes = jugadorService.cantElementosColores("green", 99);
            Integer cantJugadoresCuradores = jugadorService.cantElementosPosiciones("curador", 99);

            System.out.println(cantJugadoresOjosVerdes);
            System.out.println(cantJugadoresCuradores);

            jugadorService.guardarAdinerados(2500.00);

            System.out.println("test");
        }catch (excesoDeJugadoresException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}