package org.blbulyandavbulyan.jseminars.seminar6.homework;

import org.blbulyandavbulyan.jseminars.seminar6.homework.laptop.Laptop;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        //тут всё базовое задание
        //правда тут как-то всё в куче, но я не вижу смысла разделять это
        //поэтому пускай будет так, иногда будут сопроводительные комментарии, чтобы визуально отделить части
        Set<Laptop> laptops = new HashSet<>();
        //добавление двух одинаковых ноутбуков делаю специально, так задумано
        Laptop a = new Laptop("Lenovo", "B558", "Windows 8", "black", 4096, 8000);
        Laptop b = new Laptop("Lenovo", "B558", "Windows 8", "black", 4096, 8000);
        Laptop c = new Laptop("Asus", "ROG", "Windows 10", "red-black", 8192, 100_000);
        laptops.add(a);
        laptops.add(b);
        laptops.add(c);
        System.out.println(laptops);//по идее, дубликаты напечатать не должен
        {
            //ищем ноутбук в Set, опять же для наглядности и достоверности работы equals и hashCode я создаю новый объект
            Laptop e = new Laptop("Lenovo", "B558", "Windows 8", "black", 4096, 8000);
            if (laptops.contains(e)) {
                System.out.println("Ноутбук " + e.getVendor() + " нашёлся!");
            }
        }
        {//теперь попробуем найти то, чего нет в Set
            Laptop o = new Laptop("Sony", "vaio", "Windows 7", "black", 4096, 10_000);
            if (laptops.contains(o)) {
                System.out.println("Ноутбука " + o.getVendor() + " в Set нету!");
            }
        }
        //возьмём a и b и сравним их(должны быть равны)
        System.out.printf("a и b: %s\n", getEqualsOrNotString(a, b));
        //сравним a и с должны отличаться
        System.out.printf("a и c: %s\n", getEqualsOrNotString(a, c));


    }
    static String getEqualsOrNotString(Object a, Object b){
        return a.equals(b) ? "равны" : "не равны";
    }
}
