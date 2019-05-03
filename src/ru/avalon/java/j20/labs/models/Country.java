package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }


    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 3 * hash + Objects.hashCode(this.name);
        hash = 3 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Country: " +code+" "+name;
    }

    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {

        Pattern pattern = Pattern.compile("([A-Z]{2}):([а-яА-Я\\s]*)");
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) throw new ParseException("Не корректный ввод", 0);
        return new Country(matcher.group(1), matcher.group(2));


        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */


    }




}
