package com.sun.yelw.answer.search;


import java.io.File;
import java.util.*;

/**
 * 项目名称:   pinkstone
 * 包:        com.example.demo.a
 * 类名称:     BfsDemo
 * 类描述:     深度优先、广度优先
 * 创建人:     huangyang
 * 创建时间:   2019/10/3 17:53
 */
public class DBfsDemo {

    private static Map<Long, List<String>> aMap = new HashMap <>();

    public static void main(String[] args){

        String path = "C:\\idea\\data";

//        Map<Long, List<String>> map = doBfs(path);
//        for (long size : map.keySet()) {
//            System.out.println(size + " == " + map.get(size));
//        }

        doDfs(path);
        for (long size : aMap.keySet()) {
            System.out.println(size + " ++ " + aMap.get(size));
        }
    }

    // 给定一个文件路径，返回一个文件大小与文件路径对应的 map
    private static Map<Long, List<String>> doBfs(String rootPath) {
        Map<Long, List<String>> map = new HashMap<>();

        Queue<String> queue = new LinkedList <>();
        queue.add(rootPath);

        String curr;
        List<String> pathList;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (isFile(curr)) {
                pathList = map.getOrDefault(getFileSize(curr), new ArrayList <>());
                pathList.add(curr);
                if (1 == pathList.size()) map.put(getFileSize(curr), pathList);
            } else {
                List<String> subPaths = getSubFilePath(curr);
                if (null != subPaths) {
                    String finalCurr = curr;
                    subPaths.forEach(e -> queue.add(finalCurr + "/" + e));
                }
            }
        }
        return map;
    }

    private static void doDfs(String rootPath) {

        if (isFile(rootPath)) {
//            aMap.getOrDefault(getFileSize(rootPath), new ArrayList <>()).add(rootPath);
            List<String> pathList = aMap.getOrDefault(getFileSize(rootPath), new ArrayList <>());
            pathList.add(rootPath);
            if (pathList.size() == 1) aMap.put(getFileSize(rootPath), pathList);
        } else {
            List<String> fileList = getSubFilePath(rootPath);
            if (null == fileList) return;
            for (String currPath : fileList) {
                doDfs(rootPath + "/" + currPath);
            }
        }
    }


    private static boolean isFile(String path) {
        return new File(path).isFile();
    }

    private static Long getFileSize(String path) {
        return new File(path).length();
    }

    private static List<String> getSubFilePath(String path) {
        return null == new File(path).list() ? null : Arrays.asList(Objects.requireNonNull(new File(path).list()));
    }
}
