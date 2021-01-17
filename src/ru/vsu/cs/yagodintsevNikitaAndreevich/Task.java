package ru.vsu.cs.yagodintsevNikitaAndreevich;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        /* Список (иными словами массив){
         *   [0] (это номер внутри списка) = Map (Ключ = DefaultTableModel значение){
         *       String = Integer,
         *       String = Integer
         *   },
         *   [1] = Map{
         *       "start" = 1,
         *       "end"   = 10
         *   },
         *   [2] = Map{
         *       ....
         *   },
         *   [3] = Map{
         *       ....
         *   }
         * }
         */

    }

    public static void console(){
        List<Map<String, Integer>> lineList = new ArrayList<>();

        addLineToList(lineList, createLineMap(5, 10));
        addLineToList(lineList, createLineMap(13, 17));
        addLineToList(lineList, createLineMap(0, 10));
        addLineToList(lineList, createLineMap(12, 14));
        addLineToList(lineList, createLineMap(0, 1));

        sortListOfMapsByStartNum(lineList);
        for (Map<String, Integer> val:lineList) {
            System.out.println(val.get("start") + " " + val.get("end"));
        }
        System.out.println();
        List<Map<String, Integer>> newLineList = combineLines(lineList);


        for (Map<String, Integer> val:newLineList) {
            System.out.println(val.get("start") + " " + val.get("end"));
        }
    }

    public static int[][] resultWithMatrix(int[][] matrix){
        List<Map<String, Integer>> lineList = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            int start = matrix[i][0];
            int end = matrix[i][1];
            addLineToList(lineList, createLineMap(start, end));
        }

        sortListOfMapsByStartNum(lineList);

        List<Map<String, Integer>> newLineList = combineLines(lineList);


        int[][] newMatrix = new int[newLineList.size()][2];

        for(int i = 0; i < newMatrix.length; i++){
            Map<String, Integer> val = newLineList.get(i);
            newMatrix[i][0] = val.get("start");
            newMatrix[i][1] = val.get("end");
        }

        return newMatrix;
    }

    private static List<Map<String, Integer>> addLineToList(List<Map<String, Integer>> lineList, Map<String, Integer> line){
        if(line.get("start") == 0 && line.get("end") == 0){
            return lineList;
        }
        lineList.add(line);
        return lineList;
    }

    private static Map<String, Integer> createLineMap(Integer start, Integer end){
        Map<String, Integer> line;
        line = new HashMap<>();
        if(start < end){
            line.put("start", start);
            line.put("end", end);
        }
        else{
            line.put("start", 0);
            line.put("end", 0);
        }
        return line;
    }

    private static List<Map<String, Integer>> sortListOfMapsByStartNum(List<Map<String, Integer>> lineList){

        for (int i = 0; i < lineList.size(); i++) {
            Map<String, Integer> val1 = lineList.get(i);
            int min = val1.get("start");
            int min_i = i;
            for (int j = i + 1; j < lineList.size(); j++) {
                Map<String, Integer> val2 = lineList.get(j);

                if(val2.get("start") < min){
                    min = val2.get("start");
                    min_i = j;
                }
            }

            if (i != min_i) {
                Map<String, Integer> tmp = val1;
                lineList.set(i, lineList.get(min_i));
                lineList.set(min_i, tmp);
            }
        }


        return lineList;
    }

    private static List<Map<String, Integer>> combineLines(List<Map<String, Integer>> lineList) {
        List<Map<String, Integer>> newLineList = new ArrayList<>();

        //Map для добавления новых отрезков в List
        Map<String, Integer> tmpMap = new HashMap<>();

        Integer startNum = lineList.get(0).get("start");
        Integer endNum = lineList.get(0).get("end");

        for (int i = 0; i < lineList.size(); i++) {
            Map<String, Integer> val = lineList.get(i);


            if(val.get("start") <= endNum){
                if(endNum < val.get("end")) endNum = val.get("end");
            }
            else{
                //newLineList.add(tmpMap);
                addLineToList(newLineList, tmpMap);

                tmpMap = new HashMap<>();

                startNum = val.get("start");
                endNum = val.get("end");
            }

            tmpMap.put("start", startNum);
            tmpMap.put("end", endNum);
        }
        addLineToList(newLineList, tmpMap);



        return newLineList;
    }

}
