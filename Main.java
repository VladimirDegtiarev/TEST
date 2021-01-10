import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//  Ваш код получающий параметры с консоли
        int height = 0;
        int width = 0;
        int buffer = 0;
        Scanner sc;

        System.out.println("Эта программа печатает ромб по заданным высоте и ширине.");
        System.out.println();

        try {
            sc = new Scanner (System.in);
            System.out.print("Укажите высоту ромба (целое число): ");
            height = sc.nextInt();
            System.out.println();

            System.out.print("Укажите ширину ромба (целое число): ");
            width = sc.nextInt();
            System.out.println();

            if (height < width) {   // Если высота ромба меньше длины, то он все равно отобразится вертикально.
                buffer = height;    // О чем будет сообщено пользователю.
                height = width;
                width = buffer;
                System.out.printf("\n" + "Это ваш ромб %dx%d (повернут вертикально):"+ "\n\n", height, width);
            } else { System.out.printf("\n" + "Это ваш ромб %dx%d:"+ "\n\n", height, width); }

            Main.printDiamond(height, width);

        } catch(Exception e) {
            System.out.println("Ромб не может быть нарисован. Укажите корректные размеры ромба.");
        }

    }

    private static void printDiamond(int height, int width) {
//	Код печатающий ромб
        char[][] diamondLine = new char [height][width];

// Создание ромба выполнено за один цикл

        for (int i = 0; i <= height-1; i++) {

//-----------------------------------------------------------------------------------------------------------
// Создание ромба с нечетными одинаковыми высотой и шириной

            if ((height == width) && (height % 2 != 0) ) {
                if (i == 0) { diamondLine [i][width/2] = '#'; } // создание верхней вершины
                else if ((i > 0) && (i <= width/2 )) {
                    diamondLine [i][width/2 - i] = '#';         // создание левой верхней грани
                    diamondLine [i][width/2 + i] = '#';         // создание правой верхней грани
                }
                else if (i > width/2 ) {
                    diamondLine [i][i - width/2] = '#';                     // создание левой нижней грани
                    diamondLine [i][width - i + width/2 - 1] = '#';         // создание правой нижней грани
                }
                else if (i == height - 1) { diamondLine [i][width/2] = '#'; } // создание нижней вершины
            }

// Создание ромба с четными одинаковыми высотой и шириной

            if ((height == width) && (height % 2 == 0) ) {
                if (i == 0) { diamondLine [i][width/2 -1] = '#'; }
                else if ((i > 0) && (i <= width/2 -1)) {
                    diamondLine [i][width/2 - i -1] = '#';
                    diamondLine [i][width/2 + i -1] = '#';
                }
                else if (i > width/2 -1) {
                    diamondLine [i][i - width/2 +1] = '#';
                    diamondLine [i][width - i + width/2 - 1] = '#';
                }
                else if (i == height - 1 -1) { diamondLine [i][width/2 +1] = '#'; }
            }
//-----------------------------------------------------------------------------------------------------------
// Создание ромба с нечетной шириной и разными высотой и шириной

            if ( (height != width) && ((height % 2 == 0) && (width % 2 != 0) || (height % 2 != 0) && (width % 2 != 0)) ) {
                if (i == 0) { diamondLine [i][width/2] = '#'; }     // создание верхней вершины
                else if ((i > 0) && (i <= width/2)) {
                    diamondLine [i][width/2 - i] = '#';             // создание левой верхней грани
                    diamondLine [i][width/2 + i] = '#';             // создание правой верхней грани
                }
                else if  ( (i > width/2) && ((i <= width/2 + (height - width - 1))) ) {
                    diamondLine [i][0] = '#';                       // создание левой боковой грани
                    diamondLine [i][width -1] = '#';                // создание правой боковой грани
                }
                else if ( (i > width/2 + (height - width - 1)) ) {
                    diamondLine [i][i - (height - width - 1) - width/2 - 1] = '#';        // создание левой нижней грани
                    diamondLine [i][width - (i - (height - width - 1) - width/2)] = '#';  // создание правой нижней грани
                }
                else if (i == height - 1) { diamondLine [i][width/2] = '#'; }             // создание нижней вершины
            }
// Создание ромба с четной шириной и разными высотой и шириной

            if ((height != width) && ((height % 2 == 0) && (width % 2 == 0) || (height % 2 != 0) && (width % 2 == 0))  ) {
                if (i == 0) { diamondLine [i][width/2 - 1] = '#'; }
                else if ((i > 0) && (i <= width/2 -1)) {
                    diamondLine [i][width/2 - i -1] = '#';
                    diamondLine [i][width/2 + i -1] = '#';
                }
                else if ( (i > width/2 - 1) && ((i <= (width/2 -1) + (height - width))) ) {
                    diamondLine [i][0] = '#';
                    diamondLine [i][width -1] = '#';
                }
                else if ( ((i > (width/2 -1) + (height - width)))  && (i < height - 1)  ) {
                    diamondLine [i][i - (height - width -1) - width/2] = '#';
                    diamondLine [i][width - (i - (height - width - 1) - width/2)] = '#';
                }
                else if (i == height - 1) { diamondLine [i][width/2] = '#'; }
            }
        }

// Вывод на печать ромба

        for (int i = 0; i < diamondLine.length; i++) {
            for (int j = 0; j < diamondLine[i].length; j++) {
                if (diamondLine[i][j] != '#') { System.out.print(" ");
                } else {System.out.print(diamondLine[i][j]);}
            }
            System.out.println();
        }
    }

}
