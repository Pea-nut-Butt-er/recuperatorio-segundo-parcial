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


public class Main {
    public static void main(String[] args) throws JSONException, IOException, excesoDeJugadoresException {
        //se pasa el json a un
        JSONArray arreglo = new JSONArray(JsonUtiles.leer("jugadores"));
        JugadorService jugadorService = new JugadorService();

        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject jsonObject = arreglo.getJSONObject(i);
            jugadorService.getColores().put(jsonObject.getString("eyeColor"), jsonObject);
        }
        for (int i = 0; i < arreglo.length(); i++) {
            JSONObject jsonObject = arreglo.getJSONObject(i);
            jugadorService.getPosiciones().put(jsonObject.getString("eyeColor"), jsonObject);
        }

        System.out.println(jugadorService.getColores().toString());
        System.out.println(jugadorService.getPosiciones().toString());


        Integer cantJugadoresOjosVerdes = jugadorService.cantElementosColores("green", 2);
        Integer cantJugadoresCuradores = jugadorService.cantElementosColores("curador", 2);

        System.out.println(cantJugadoresOjosVerdes);
        System.out.println(cantJugadoresCuradores);





    }
}