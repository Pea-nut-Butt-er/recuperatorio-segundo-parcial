package service;

import exceptions.excesoDeJugadoresException;
import model.Jugador;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class JugadorService {
    private TreeMap <String, JSONObject> colores = new TreeMap<>();
    private TreeMap <String, JSONObject> posiciones = new TreeMap<>();

    public JugadorService() {
    }

    public JugadorService(TreeMap<String, JSONObject> colores, TreeMap<String, JSONObject> posiciones) {
        this.colores = colores;
        this.posiciones = posiciones;
    }

    public TreeMap<String, JSONObject> getColores(){
        return colores;
    }

    public void setColores(TreeMap<String, JSONObject> colores) {
        this.colores = colores;
    }

    public TreeMap<String, JSONObject> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(TreeMap<String, JSONObject> posiciones) {
        this.posiciones = posiciones;
    }

    @Override
    public String toString() {
        return "JugadorService{" +
                "colores=" + colores +
                ", posiciones=" + posiciones +
                '}';
    }

    public Integer cantElementosColores(String color, Integer max) throws excesoDeJugadoresException {
        Integer i = 0;
        for(Map.Entry<String, JSONObject> e : colores.entrySet()){
            if(e.getKey() == color){
                i++;
            }
        }
        if(i > max){
            throw new excesoDeJugadoresException("En la coleccion colores hay " + i + " jugadores con color de ojo " + color + " ,esos son " + (i - max) + " de mas");
        }
        return i;
    }

    public Integer cantElementosPosiciones(String posicion, Integer max) throws excesoDeJugadoresException {
        Integer i = 0;
        for(Map.Entry<String, JSONObject> e : posiciones.entrySet()){
            if(e.getKey() == posicion){
                i++;
            }
        }
        if(i > max){
            throw new excesoDeJugadoresException("En la coleccion posiciones hay " + i + " jugadores en la posicion " + posicion + " ,esos son " + (i - max) + " de mas");
        }
        return i;
    }

    public void guardarAdinerados(Double maxBalance) throws JSONException, IOException {
        File file = new File("adinerador.dat");

        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        for(Map.Entry<String, JSONObject> e : posiciones.entrySet()){


            Double balance = Double.parseDouble(e.getValue().getString("balance"));
            if(balance > maxBalance){
                printWriter.println(e.getValue().toString());
            }
        }
    }
}
