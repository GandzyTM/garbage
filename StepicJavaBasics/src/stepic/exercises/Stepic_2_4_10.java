package stepic.exercises;

/**
 * Created by Alex on 20.09.2016.
 *
 * Вам дан список ролей и сценарий пьесы в виде массива строчек.
 * Каждая строчка сценария пьесы дана в следующем виде:
 * Роль: текст
 *
 * Текст может содержать любые символы.
 *
 * Напишите метод, который будет группировать строчки по ролям, пронумеровывать
 * их и возвращать результат в виде готового текста (см. пример). Каждая группа
 * распечатывается в следующем виде:
 *
 * Роль:
 * i) текст
 * j) текст2
 * ...
 * ==перевод строки==
 *
 * i и j -- номера строк в сценарии. Индексация строчек начинается с единицы,
 * выводить группы следует в соответствии с порядком ролей. Переводы строк между
 * группами обязательны, переводы строк в конце текста не учитываются.
 * Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей –
 * соответственно, неправильная сборка результирующей строчки может выйти за ограничение по времени.
 *
 * Обратите внимание еще на несколько нюансов:
 *
 * имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
 * название одной роли может быть префиксом названия другой роли;
 * роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
 * в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
 * будьте внимательны, не добавляйте лишних пробелов в конце строк.
 */
public class Stepic_2_4_10 {
    // тестовые данные
    private static String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
    private static String[] textLines = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder resultText = new StringBuilder();

        for (String role: roles)
        {
            resultText.append(role + ":" + "\n");

            for (int i = 0; i < textLines.length; i++)
            {
                String[] splitLine = textLines[i].split(": ", 2);
                String roleFromText = splitLine[0];
                String roleText     = splitLine[1];

                if (role.equals(roleFromText))
                {
                    resultText.append((i + 1) + ") " + roleText + "\n");
                }
            }

            resultText.append("\n");
        }

        return resultText.toString();
    }

    public static void main(String[] args) {
        System.out.println(printTextPerRole(roles, textLines));
    }
}
