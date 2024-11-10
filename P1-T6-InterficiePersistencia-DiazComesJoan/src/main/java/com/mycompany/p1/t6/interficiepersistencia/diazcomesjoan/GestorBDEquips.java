/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;


import java.util.List;


/**
 *
 * @author micro
 */
public interface GestorBDEquips {
     /**
     * Insereix producte a la BD
     *
     * @param e Equip a inserir
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void afegirEquip(P1T6ModelDiazComesJoan e) throws P1T6InterficiePersistenciaDiazComesJoan;
    
     /**
     * Insereix producte a la BD
     *
     * @param j Jugador a inserir
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void afegirJugador(P1T6ModelDiazComesJoan j) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    
     /**
     * Insereix producte a la BD
     *
     * @param c Categoria a inserir
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void afegirCategoria(P1T6ModelDiazComesJoan c) throws P1T6InterficiePersistenciaDiazComesJoan;
    
     /**
     * Insereix producte a la BD
     *
     * @param t Temporada a inserir
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void afegirTemporada(P1T6ModelDiazComesJoan t) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Tancam la conexio a la base de dades
     *
     * @throws org.milaifontanals.empresa.persistencia.com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    void tancarCapa() throws P1T6InterficiePersistenciaDiazComesJoan;

    /**
     * Eliminar llistat o un equip
     *
     * @param e Llista de codis a eliminar
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    void eliminarEquip(List<Integer> e) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Eliminar llistat o un temporada
     *
     * @param t Temporada a eliminar
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    void eliminarTemporada(List<Integer> t) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Eliminar llistat o un jugador
     *
     * @param j Jugador a eliminar
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    void eliminarJugador(List<Integer> j) throws P1T6InterficiePersistenciaDiazComesJoan;

    /**
     * Eliminar llistat o un categoria
     *
     * @param c Categoria a eliminar
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    void eliminarCategoria(List<Integer> c) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Obtenir tots els equips de la BD
     *
     * @return Llista de equips recuperats
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    List<P1T6ModelDiazComesJoan> torbarEquip() throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Obtenir tots els jugadors de la BD
     *
     * @return Llista de jugadors recuperats
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    List<P1T6ModelDiazComesJoan> torbarJugador() throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Obtenir totes les categories de la BD
     *
     * @return Llista de categories recuperades
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    List<P1T6ModelDiazComesJoan> torbarCategoria() throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Obtenir totes les temporades de la BD
     *
     * @return Llista de temporades recuperades
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    List<P1T6ModelDiazComesJoan> torbarTemporada() throws P1T6InterficiePersistenciaDiazComesJoan;
    

    /**
     * Editar un equip
     *
     * @param e Equip a editar
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void editarEquip(P1T6ModelDiazComesJoan e) throws P1T6InterficiePersistenciaDiazComesJoan;
    
    /**
     * Editar un jugador
     *
     * @param j Jugador a editar
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void editarJugador(P1T6ModelDiazComesJoan j) throws P1T6InterficiePersistenciaDiazComesJoan;

    
    /**
     * Editar un categoria
     *
     * @param c Categoria a editar
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void editarCategoria(P1T6ModelDiazComesJoan c) throws P1T6InterficiePersistenciaDiazComesJoan;

    
    /**
     * Editar un temporada
     *
     * @param t Temporada a editar
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void editarTemporada(P1T6ModelDiazComesJoan t) throws P1T6InterficiePersistenciaDiazComesJoan;


    /**
     * Confirma els canvis a la BD
     *
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void confirmarCanvis() throws P1T6InterficiePersistenciaDiazComesJoan;

    /**
     * Desfer els canvis no confirmats a la BD
     *
     * @throws P1T6InterficiePersistenciaDiazComesJoan
     */
    void desferCanvis() throws P1T6InterficiePersistenciaDiazComesJoan;

    public static class P1T6ModelDiazComesJoan {

        public P1T6ModelDiazComesJoan() {
        }
    }
}
