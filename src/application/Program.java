package application;

import java.util.ArrayList;
import java.util.List;
import entity.Circle;
import entity.Rectangle;
import entity.Shape;

public class Program {

    public static void main(String[] args) {

        List<Shape> listShape = new ArrayList<>();
        listShape.add(new Rectangle(2.5, 4.6));
        listShape.add(new Circle(5.9));

        List<Circle> listCircle = new ArrayList<>();
        listCircle.add(new Circle(5.9));

        List<Rectangle> listRectangle = new ArrayList<>();
        listRectangle.add(new Rectangle(2.5, 4.6));

        // Este método aceita APENAS List<Shape>
        System.out.println("Total value: " + calcShapes(listShape));

        // Este método aceita List<Shape> ou listas de qualquer subtipo de Shape
        System.out.println("Total value: " + calcTypeShapes(listCircle));
        System.out.println("Total value: " + calcTypeShapes(listRectangle));
        System.out.println("Total value: " + calcTypeShapes(listShape));
    }

    // =====================================================
    // Método sem wildcard
    //
    // Aceita exclusivamente List<Shape>.
    // List<Circle> e List<Rectangle> NÃO são aceitas,
    // pois generics em Java não são covariantes.
    // =====================================================
    public static double calcShapes(List<Shape> list) {

        // É permitido adicionar subtipos de Shape,
        // pois a lista é garantidamente List<Shape>
        // list.add(new Circle(5.9));

        double sum = 0;

        for (Shape shape : list) {
            sum += shape.area();
        }
        return sum;
    }

    // =====================================================
    // Uso de wildcard limitado superior (? extends Shape)
    //
    // Aceita:
    // - List<Shape>
    // - List<Circle>
    // - List<Rectangle>
    //
    // Ideal para cenários de LEITURA (consumo de dados)
    // =====================================================
    public static double calcTypeShapes(List<? extends Shape> list) {

        // Erro de compilação:
        // Não é permitido adicionar elementos, pois o compilador
        // não sabe qual subtipo concreto de Shape a lista representa.
        //
        // Se a lista for List<Rectangle>, adicionar Circle quebraria
        // a segurança de tipos.
        // list.add(new Circle(5.9));

        double sum = 0;

        // Leitura segura: todo elemento é garantidamente um Shape
        for (Shape shape : list) {
            sum += shape.area();
        }
        return sum;
    }
}