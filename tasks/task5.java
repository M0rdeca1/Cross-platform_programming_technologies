package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class task5 {

	/* 1. Создайте функцию, которая возвращает true, если две строки имеют один и тот же
       буквенный шаблон, и false в противном случае. */

    public static boolean sameLetterPattern(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Character> match = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (!match.containsKey(a.charAt(i)))
                match.put(a.charAt(i), b.charAt(i));
            if (b.charAt(i) != match.get(a.charAt(i)))
                return false;
        }
        return true;
    }

    /* 2. Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и
       радиалами, помеченными по часовой стрелке сверху как A-H.

       Создайте функцию, которая принимает координаты паука и мухи и возвращает
       кратчайший путь для паука, чтобы добраться до мухи.

       Стоит отметить, что кратчайший путь должен быть рассчитан "геометрически", а не путем
       подсчета количества точек, через которые проходит этот путь. Мы могли бы это устроить:

       Угол между каждой парой радиалов одинаков (45 градусов).

       Расстояние между каждой парой колец всегда одинаково (скажем, "x"). */

    public static String spiderVsFly(String spider, String fly) {
	    /*

	       1. спуститься в центр и пойти по нужной ветке
	          это просто сумма номеров колец мухи и павука

	       2. спуститься/подняться до нужного кольца и пойти по кольцу
	          разница между кольцами павука и мухи + (разница между веток) * длина пути на кольце

	          длина пути на кольце = 2 * x * sin(45 / 2) = x * 0.76536686473
	    */

        int sx = spider.charAt(0) - 65;
        int sy = spider.charAt(1) - 48;
        int fx = fly.charAt(0) - 65;
        int fy = fly.charAt(1) - 48;

        double strategyDist1 = sy + fy;
        double strategyDist2 = Math.abs(sy - fy) + ((sx + fx) % 8) * fy * 0.76536686473;

        String path = "";

        if (strategyDist1 <= strategyDist2) {
            for (int i = 0; i < sy; i++) {
                path += spider.charAt(0);
                path += sy - i;
                path += '-';
            }
            path += "A0-";
            for (int i = 0; i < fy; i++) {
                path += fly.charAt(0);
                path += i + 1;
                path += '-';
            }
        } else {
            for (int i = 0; i < Math.abs(sy - fy); i++) {
                path += spider.charAt(0);
                if (sy > fy) path += sy - i;
                else path += sy + i;
                path += '-';
            }
            for (int i = 0; i <= (sx + fx) % 8; i++) {
                path += (char) (65 + (sx + i) % 8);
                path += fly.charAt(1);
                path += '-';
            }
        }

        return path.substring(0, path.length() - 1);
    }

	/* 3. Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
       числа. Преобразование числа в строку не допускается, поэтому подход является
       рекурсивным. */

    public static int _digitsCount(long number) {
        if (number == 0) return 0;
        return 1 + _digitsCount(number / 10);
    }

    public static int digitsCount(long number) {
        return 1 + _digitsCount(number / 10);
    }

    /* 4. В игроки пытаются набрать очки, формируя слова, используя буквы из 6-
       буквенного скремблированного слова. Они выигрывают раунд, если им удается
       успешно расшифровать слово из 6 букв.

       Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
       буквенное слово и возвращает общее количество очков, набранных игроком в
       определенном раунде, используя следующую рубрику:

       3-буквенные слова-это 1 очко
       4-буквенные слова-это 2 очка
       5-буквенные слова-это 3 очка
       6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)

       Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
       буквенных расшифрованных слов) считаются 0 очками.

       Примечание:
       - Если 6-буквенное слово имеет несколько анаграмм, считайте каждую 6-буквенную
       расшифровку дополнительными 54 очками. Например, если слово arches, а игрок угадал
       arches и chaser, добавьте 108 очков для обоих слов.
       - Вы можете играть в Текстовый Твист здесь: http://text-twist2.com */

    public static int[] getCharset(String word) {
        int[] charset = new int[127];
        for (char c : word.toCharArray()) charset[c]++;
        return charset;
    }

    public static int totalPoints(String[] words, String scramble) {
        int points = 0;
        int[] scrambleCharset = getCharset(scramble);
        for (int i = 0; i < words.length; i++) {
            int[] wordCharset = getCharset(words[i]);
            boolean good = true;
            for (int j = 0; j < 127; j++)
                if (wordCharset[j] > scrambleCharset[j]) {
                    good = false;
                    break;
                }
            if (good) {
                points += words[i].length() - 2;
                if (words[i].length() == 6) points += 50;
            }
        }
        return points;
    }

	/* 5. Последовательный прогон-это список соседних последовательных целых чисел.
       Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
       функцию, которая принимает массив чисел и возвращает длину самого длинного
       последовательного запуска. */

    public static int longestRun(int[] arr) {
        int max = 1;
        int cur = 1;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i + 1] - arr[i] == 1 || arr[i + 1] - arr[i] == -1) {
                cur++;
                if (max < cur) max = cur;
            } else cur = 1;
        return max;
    }

    /* 6. Какой процент вы можете набрать на тесте, который в одиночку снижает средний
       балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
       функцию, которая возвращает ответ. Округлите до ближайшего процента. */

    public static String takeDownAverage(String[] percents) {
        int avg = 0;
        for (String s : percents)
            avg += Integer.parseInt(s.substring(0, s.length() - 1));
        return (avg / percents.length - percents.length * 5 - 5) + "%";
    }

    /* 7. Учитывая предложение с числами, представляющими расположение слова,
       встроенного в каждое слово, верните отсортированное предложение */

    public static String rearrange(String str) {
        String[] words = str.split(" ");
        String[] res = new String[words.length];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) {
                    res[word.charAt(i) - 48 - 1] = word.substring(0, i) + word.substring(i + 1);
                    break;
                }
            }
        }
        return String.join(" ", res);
    }

    /* 8. Напишите функцию, которая делает первое число как можно больше, меняя его
       цифры на цифры во втором числе.

       Примечание:
       - Каждая цифра во втором числе может быть использована только один раз.
       - Можно использовать ноль для всех цифр второго числа. */

    public static Integer[] splitNumber(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(n % 10);
            n /= 10;
        }
        return res.toArray(new Integer[res.size()]);
    }

    public static int maxPossible(int n, int r) {
        Integer[] num = splitNumber(n);
        Integer[] rnum = splitNumber(r);
        Arrays.sort(rnum, Collections.reverseOrder());
        int rnumindex = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] < rnum[rnumindex]) {
                num[i] = rnum[rnumindex];
                rnumindex++;
            }
            if (rnumindex == rnum.length)
                break;
        }
        n = 0;
        int dec = 1;
        for (int i : num) {
            n += i * dec;
            dec *= 10;
        }
        return n;
    }

    /* 9. В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух
       разных городах. Вам дается строка cityA и связанная с ней строка timestamp (time
       in cityA) с датой, отформатированной в полной нотации США, как в этом примере:

       "July 21, 1983 23:01"

       Вы должны вернуть новую метку времени с датой и соответствующим временем в cityB,
       отформатированную как в этом примере:

       "1983-7-22 23:01"

       Список данных городов и их смещения по Гринвичу (среднее время по Гринвичу)
       приведены в таблице ниже.

       GMT City
       - 08:00 Los Angeles
       - 05:00 New York
       - 04:30 Caracas
       - 03:00 Buenos Aires
       00:00 London
       + 01:00 Rome
       + 03:00 Moscow
       + 03:30 Tehran
       + 05:30 New Delhi
       + 08:00 Beijing
       + 10:00 Canberra

       Примечание:
       - Обратите внимание на часы и минуты, ведущий 0 необходим в возвращаемой метке
       времени, когда они представляют собой одну цифру.
       - Обратите внимание на города с получасовыми смещениями. */

    public static SimpleDateFormat parseDate = new SimpleDateFormat("MMMM d, yyyy HH:mm");
    public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-M-d HH:mm");

    public static String getGMT(String city) {
        if (city == "Los Angeles") return "GMT-08:00";
        if (city == "New York") return "GMT-05:00";
        if (city == "Caracas") return "GMT- 04:30";
        if (city == "Buenos Aires") return "GMT-03:00";
        if (city == "London") return "GMT00:00";
        if (city == "Rome") return "GMT+01:00";
        if (city == "Moscow") return "GMT+03:00";
        if (city == "Tehran") return "GMT+03:30";
        if (city == "New Delhi") return "GMT+05:30";
        if (city == "Beijing") return "GMT+08:00";
        if (city == "Canberra") return "GMT+10:00";
        return "GMT";
    }

    public static String timeDifference(
            String cityA, String timestamp, String cityB
    ) {
        try {
            parseDate.setTimeZone(TimeZone.getTimeZone(getGMT(cityA)));
            formatDate.setTimeZone(TimeZone.getTimeZone(getGMT(cityB)));
            Date date = parseDate.parse(timestamp);
            return formatDate.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    /* 10. Новое число-это число, которое не является перестановкой любого меньшего
       числа. 869-это не новое число, потому что это просто перестановка меньших чисел,
       689 и 698. 509-это новое число, потому что оно не может быть образовано
       перестановкой любого меньшего числа (ведущие нули не допускаются).
       Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
       если целое число является новым числом, и false, если это не так. */

    public static boolean isNew(int n) {
        Integer[] num = splitNumber(n);
        for (int i = 0; i < num.length - 1; i++)
            if (num[i] > 0 && num[i] < num[num.length - 1])
                return false;
        return true;
    }




}
