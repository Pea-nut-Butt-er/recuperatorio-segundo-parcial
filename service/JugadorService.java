package service;

import exceptions.excesoDeJugadoresException;
import model.Jugador;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class JugadorService {
    private TreeMap <String,  ArrayList<JSONObject>> colores = new TreeMap<>();
    private TreeMap <String,  ArrayList<JSONObject>> posiciones = new TreeMap<>();

    public JugadorService() {
    }

    public JugadorService(TreeMap<String,  ArrayList<JSONObject>> colores, TreeMap<String,  ArrayList<JSONObject>> posiciones) {
        this.colores = colores;
        this.posiciones = posiciones;
    }

    public TreeMap<String, ArrayList<JSONObject>> getColores() {
        return colores;
    }

    public void setColores(TreeMap<String, ArrayList<JSONObject>> colores) {
        this.colores = colores;
    }

    public TreeMap<String, ArrayList<JSONObject>> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(TreeMap<String, ArrayList<JSONObject>> posiciones) {
        this.posiciones = posiciones;
    }

    public Integer cantElementosColores(String color, Integer max) throws excesoDeJugadoresException, JSONException {
        Integer i = 0;
        for(Map.Entry<String,  ArrayList<JSONObject>> e : colores.entrySet()){
            for (JSONObject j: e.getValue()) {
                if(j.getString("eyeColor").equals(color)){
                    i++;
                }
            }
        }
        System.out.println(i);
        if(i > max){
            throw new excesoDeJugadoresException("En la coleccion colores hay " + i + " jugadores con color de ojo " + color + " ,esos son " + (i - max) + " de mas");
        }
        return i;
    }

    public Integer cantElementosPosiciones(String posicion, Integer max) throws excesoDeJugadoresException, JSONException {
        Integer i = 0;
        for(Map.Entry<String,  ArrayList<JSONObject>> e : posiciones.entrySet()){
            for (JSONObject j: e.getValue()) {
                if(j.getString("position").equals(posicion)){
                    i++;
                }
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

        for(Map.Entry<String,  ArrayList<JSONObject>> e : posiciones.entrySet()){
            for (JSONObject j: e.getValue()) {
                Double balance = j.getDouble("balance");
                if (balance > maxBalance) {
                    printWriter.println(e.getValue().toString());
                }
            }
        }
        printWriter.close();
    }
}
