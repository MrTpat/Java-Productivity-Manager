/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nongui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ptila
 */
public class test {
    public static void main(String[] args){
        Blocker b = new Blocker();
        b.getSites().remove(1);
        try {
            b.write();
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> s = new ArrayList<String>();
        System.out.print(b.getSites());
    }
}
