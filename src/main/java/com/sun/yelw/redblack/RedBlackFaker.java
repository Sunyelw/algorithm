package com.sun.yelw.redblack;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.redblack
 * 类名称:     RedBlackFaker
 * 类描述:     red-black 伪代码
 * 创建人:     huangyang
 * 创建时间:   2019/8/15 7:37
 */
public class RedBlackFaker {

    public static void main(String[] args){

        /*
         *  while z.p.color == RED
         *
         *      if z.p == z.p.p.left
         *
         *          y = z.p.p.right
         *
         *          if y.color == RED               // case 1  uncle red  叔红
         *
         *              z.p.color = BLACK
         *
         *              y.color = BLACK
         *
         *              z.p.p.color = RED
         *
         *              z = z.p.p
         *
         *          elseif z == z.p.right           // case 2 uncle black right 叔黑左子
         *
         *              z = z.p
         *
         *              LEFT_ROTATE(T, z)
         *
         *          z.p.color = BLACK               // case 3 uncle black left 叔黑右子
         *
         *          z.p.p.color = RED
         *
         *          RIGHT_ROTATE(T, z.p.p)
         *
         *      else (same as 'then' clause with 'right' and 'left' exchanged)
         *
         *  T.root.color = BLACK
         *
         */

    }

}
