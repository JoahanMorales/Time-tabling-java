package time.tabling;

import java.util.*;

public class DataFactory {
    public static List<Subjects> buildFromTable() {
        List<Subjects> list = new ArrayList<>();

        // ===== 2AM1 =====
        list.add(Subjects.fromBlocks(8.7, "Miguel Santiago", "Suarez Castañon",
                "ALGORITMOS Y ESTRUCTURAS DE DATOS", "2AM1",
                new Subjects.Block("14", "0700-0830"),
                new Subjects.Block("5",  "0830-1000")
        ));

        list.add(Subjects.fromBlocks(9.1, "Alejandro", "Gonzalez Cisneros",
                "ALGEBRA LINEAL", "2AM1",
                new Subjects.Block("235", "1030-1200")   
        ));

        list.add(Subjects.fromBlocks(8.4, "Jean", "Ortega Gonzalez",
                "ETICA Y LEGALIDAD", "2AM1",
                new Subjects.Block("235", "0700-0830")
        ));

        list.add(Subjects.fromBlocks(9.3, "Cesar", "Hernandez Vasquez",
                "CALCULO MULTIVARIABLE", "2AM1",
                new Subjects.Block("134", "0830-1000"), 
                new Subjects.Block("5",   "1200-1330")
        ));

        list.add(Subjects.fromBlocks(8.0, "Rafael", "Ramirez Tenorio",
                "FUNDAMENTOS ECONOMICOS", "2AM1",
                new Subjects.Block("1", "1030-1200"),
                new Subjects.Block("2", "0830-1000"),
                new Subjects.Block("4", "1030-1200")
        ));

        // ===== 2AM2 =====
        list.add(Subjects.fromBlocks(9.0, "Jose Marco Antonio", "Rueda Melendez",
                "ALGORITMOS Y ESTRUCTURAS DE DATOS", "2AM2",
                new Subjects.Block("235", "0700-0830")
        ));

        list.add(Subjects.fromBlocks(8.6, "Roberto", "Vazquez Arreguin",
                "ALGEBRA LINEAL", "2AM2",
                new Subjects.Block("134", "0830-1000")
        ));

        list.add(Subjects.fromBlocks(7.9, "Lilian", "Martinez Acosta",
                "ETICA Y LEGALIDAD", "2AM2",
                new Subjects.Block("14", "0700-0830"),
                new Subjects.Block("5",  "0830-1000")
        ));

        list.add(Subjects.fromBlocks(9.7, "Cesar Roman", "Martinez Garcia",
                "CALCULO MULTIVARIABLE", "2AM2",
                new Subjects.Block("1", "1030-1200"),
                new Subjects.Block("2", "0830-1000"),
                new Subjects.Block("3", "1200-1330"),
                new Subjects.Block("4", "1030-1200")
        ));

        list.add(Subjects.fromBlocks(8.2, "Rafael", "Ramirez Tenorio",
                "FUNDAMENTOS ECONOMICOS", "2AM2",
                new Subjects.Block("235", "1030-1200")
        ));

        return list;
    }
}
