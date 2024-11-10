/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p1.t6.capaoracle.diazcomesjoan;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.p1.t6.model.diazcomesjoan;

/**
 *
 * @author micro
 */
public class P1T6CapaOracleDiazComesJoan {

        /*
     * Aquest objecte és el que ha de mantenir la connexió amb el SGBD Es crea
     * en el constructor d'aquesta classe i manté la connexió fins que el
     * programador decideix tancar la connexió amb el mètode tancarCapa
     */
    private Connection conn;

    /**
     * Sentències preparades que es crearan només 1 vegada i s'utilitzaran
     * tantes vegades com siguin necessàries. En aquest programa es creen la
     * primera vegada que es necessiten i encara no han estat creades. També es
     * podrien crear al principi del programa, una vegada establerta la
     * connexió.
     */
    private PreparedStatement psDelList;
    private PreparedStatement psUpdate;
    private PreparedStatement psInsert;

    /**
     * Estableix la connexió amb la BD.Les dades que necessita (url, usuari i
     * contrasenya) es llegiran d'un fitxer de configuració anomenat
     * empresaJDBC.xml" que cercarà a l'arrel de l'aplicació i que ha de
     * contenir les següents claus: url, user, password
     *
     * En cas que l'aplicació s'executés en Java anterior a 1.6, caldria també
     * passar el nom de la classe JDBC que permet la connexió amb el SGBDR.
     *
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    public P1T6CapaOracleDiazComesJoan() throws P1T6InterficiePersistenciaDiazComesJoan {
        String nomFitxer = "equips.xml";
        try {
            Properties props = new Properties();
            props.loadFromXML(new FileInputStream(nomFitxer));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new P1T6InterficiePersistenciaDiazComesJoan("L'arxiu " + nomFitxer + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Hi han problemes en recuperar l'arxiu " + nomFitxer, ex);
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("No es pot connectar.", ex);
        }
    }

    /**
     * Tanca la connexió
     *
     * @throws com.mycompany.p1.t6.interficiepersistencia.diazcomesjoan;
     */
    @Override
    public void tancarCapa() throws P1T6InterficiePersistenciaDiazComesJoan {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Rollback Error.", ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("No es pot tancar la connexio.\n", ex);
            }
        }
    }

    @Override
    public void afegirEquip(P1T6ModelDiazComesJoan e) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psInsert == null) {
            try {
                psInsert = conn.prepareStatement("INSERT INTO equips VALUES (?,?)");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psInsert", ex);
            }
        }
        try {
            psInsert.setInt(1, e.getEquipNum());
            psInsert.setString(2, e.getEquipName());
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar inserir l'equip " + e.getEquipNum(), ex);
        }
    }
    
    public void afegirJugador(P1T6ModelDiazComesJoan j) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psInsert == null) {
            try {
                psInsert = conn.prepareStatement("INSERT INTO jugadors VALUES (?,?)");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psInsert", ex);
            }
        }
        try {
            psInsert.setInt(1, j.getEquipNum());
            psInsert.setString(2, j.getEquipName());
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar inserir el jugador " + j.getEquipNum(), ex);
        }
    }
    
    public void afegirCategoria(P1T6ModelDiazComesJoan c) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psInsert == null) {
            try {
                psInsert = conn.prepareStatement("INSERT INTO categories VALUES (?,?)");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psInsert", ex);
            }
        }
        try {
            psInsert.setInt(1, c.getEquipNum());
            psInsert.setString(2, c.getEquipName());
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar inserir la categoria " + c.getEquipNum(), ex);
        }
    }
    
    public void afegirTemporada(P1T6ModelDiazComesJoan t) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psInsert == null) {
            try {
                psInsert = conn.prepareStatement("INSERT INTO temporades VALUES (?,?)");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psInsert", ex);
            }
        }
        try {
            psInsert.setInt(1, t.getEquipNum());
            psInsert.setString(2, t.getEquipName());
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar inserir la temporada " + t.getEquipNum(), ex);
        }
    }

    @Override
    public void actualitzarEquip(P1T6ModelDiazComesJoan e) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psUpdate == null) {
            try {
                psUpdate = conn.prepareStatement("UPDATE equips SET nom=? WHERE eq_num=?");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psUpdate", ex);
            }
        }
        try {
            psUpdate.setString(1, e.getEquipName());
            psUpdate.setInt(2, e.getEquipNum());
            int q = psUpdate.executeUpdate();
            if (q == 0) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("No s'ha modificat ja que no existeix.");
            }
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar modificar l'equip " + e.getEquipNum(), ex);
        }
    }
    
    @Override
    public void actualitzarJugadors(P1T6ModelDiazComesJoan j) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psUpdate == null) {
            try {
                psUpdate = conn.prepareStatement("UPDATE jugadors SET nom=? WHERE jug_num=?");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psUpdate", ex);
            }
        }
        try {
            psUpdate.setString(1, j.getEquipName());
            psUpdate.setInt(2, j.getEquipNum());
            int q = psUpdate.executeUpdate();
            if (q == 0) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("No s'ha modificat ja que no existeix");
            }
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar modificar el jugador" + j.getEquipNum(), ex);
        }
    }
    
    @Override
    public void actualitzarCategories(P1T6ModelDiazComesJoan c) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psUpdate == null) {
            try {
                psUpdate = conn.prepareStatement("UPDATE categories SET nom=? WHERE cat_num=?");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psUpdate", ex);
            }
        }
        try {
            psUpdate.setString(1, c.getEquipName());
            psUpdate.setInt(2, c.getEquipNum());
            int q = psUpdate.executeUpdate();
            if (q == 0) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("No s'ha modificat ja que no existeix");
            }
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar modificar la categoria " + c.getEquipNum(), ex);
        }
    }
    
    @Override
    public void actualitzarTemporada(P1T6ModelDiazComesJoan t) throws P1T6InterficiePersistenciaDiazComesJoan {
        if (psUpdate == null) {
            try {
                psUpdate = conn.prepareStatement("UPDATE temporades SET nom=? WHERE temp_num=?");
            } catch (SQLException ex) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("Error en preparar sentència psUpdate", ex);
            }
        }
        try {
            psUpdate.setString(1, t.getEquipName());
            psUpdate.setInt(2, t.getEquipNum());
            int q = psUpdate.executeUpdate();
            if (q == 0) {
                throw new P1T6InterficiePersistenciaDiazComesJoan("No s'ha modificat ja que n.o existeix");
            }
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en intentar modificar la temporada " + t.getEquipNum(), ex);
        }
    }

    @Override
    public void confirmarCanvis() throws P1T6InterficiePersistenciaDiazComesJoan {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en confirmar canvis", ex);
        }
    }

    @Override
    public void desferCanvis() throws P1T6InterficiePersistenciaDiazComesJoan {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            throw new P1T6InterficiePersistenciaDiazComesJoan("Error en desfer canvis", ex);
        }
    }
    }
}
