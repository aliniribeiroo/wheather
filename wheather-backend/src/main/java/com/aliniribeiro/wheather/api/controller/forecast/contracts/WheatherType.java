package com.aliniribeiro.wheather.api.controller.forecast.contracts;

public enum WheatherType {

    THUNDER_1(200, "Trovoada com chuva fraca", "11d"),
    THUNDER_2(201, "Trovoada com chuva", "11d"),
    THUNDER_3(202, "Trovoada com chuva forte", "11d"),
    THUNDER_4(210, "Trovoada leve", "11d"),
    THUNDER_5(211, "Trovoada", "11d"),
    THUNDER_6(221, "Tempestade trançada", "11d"),
    THUNDER_7(230, "Trovoada com chuvisco ligeiro", "11d"),
    THUNDER_8(231, "Trovoada com chuvisco pesado", "11d"),
    THUNDER_9(232, "Trovoada com chuva forte", "11d"),

    DRIZZLE_1(300, "Chuvisco de intensidade leve", "09d"),
    DRIZZLE_2(301, "Garoa  ", "09d"),
    DRIZZLE_3(302, "Chuvisco de intensidade pesada", "09d"),
    DRIZZLE_4(310, "Intensidade de luz chuvisco chuva ", "09d"),
    DRIZZLE_5(311, "Chuva de chuvisco", "09d"),
    DRIZZLE_6(312, "Chuva forte chuvisco", "09d"),
    DRIZZLE_7(313, "Chuva de chuva e chuvisco", "09d"),
    DRIZZLE_8(314, "Chuva forte e chuva de chuvisco", "09d"),
    DRIZZLE_9(321, "Chuvisco do chuveiro ", "09d"),

    RAIN_1(500, "Chuva leve", "13d"),
    RAIN_2(501, "Chuva moderada ", "13d"),
    RAIN_3(502, "Chuva de intensidade pesada", "13d"),
    RAIN_4(503, "Chuva muito pesada ", "13d"),
    RAIN_5(504, "Chuva extrema", "13d"),
    RAIN_6(511, "Chuva congelante", "13d"),
    RAIN_7(520, "Chuva de intensidade leve", "13d"),
    RAIN_8(521, "Chuva ", "13d"),
    RAIN_9(522, "Chuva de intensidade pesada", "13d"),
    RAIN_10(531, "Chuva áspera ", "13d"),

    SNOW_0(600, "Neve leve", "13d"),
    SNOW_1(601, "Neve", "13d"),
    SNOW_2(602, "Neve pesada", "13d"),
    SNOW_3(615, "Chuva leve e neve", "13d"),
    SNOW_4(616, "Chuva e neve", "13d"),
    SNOW_5(620, "Alta iluminação e neve", "13d"),
    SNOW_6(621, "Nevasca", "13d"),
    SNOW_7(622, "Nevasca pesada", "13d"),

    SLEET_0(611, "Granizo", "13d"),
    SLEET_2(612, "Chuva de Granizo ", "13d"),
    SMOKE(711, "Fumaça ", "50d"),
    HAZE(721, "Neblina ", "50d"),
    DUST_SAND(731, "Areia, giros de poeira ", "50d"),
    DUST(751, "Poeira ", "50d"),
    SAND(761, "Areia ", "50d"),
    FOG(741, "Nevoeiro ", "50d"),
    VULCANIC_ASH(762, "Cinzas vulcânicas ", "50d"),
    SQUALLS(771, "Rajadas", "50d"),
    TORNADO(781, "Tornado", "50d"),
    MIST(701, "Névoa ", "50d"),
    CLOUDS_1(801, "Poucas nuvens  ", "02d"),
    CLOUDS_2(802, "Nuvens espalhadas ", "03d"),
    CLOUDS_3(803, "Nuvens quebradas ", "04d"),
    CLOUDS_4(804, "Nuvens nubladas ", "04d"),
    CLEAR(800, "Céu claro ", "01d");


    private int code;
    public String description;
    public String icon;

    WheatherType(int code, String description, String icon) {
        this.code = code;
        this.description = description;
        this.icon = icon;
    }

    public static WheatherType getByCode(int code) {
        switch (code) {
            case 800:
                return CLEAR;
            case 804:
                return CLOUDS_4;
            case 803:
                return CLOUDS_3;
            case 802:
                return CLOUDS_2;
            case 801:
                return CLOUDS_1;
            case 701:
                return MIST;
            case 781:
                return TORNADO;
            case 771:
                return SQUALLS;
            case 762:
                return VULCANIC_ASH;
            case 741:
                return FOG;
            case 761:
                return SAND;
            case 751:
                return DUST;
            case 731:
                return DUST_SAND;
            case 721:
                return HAZE;
            case 711:
                return SMOKE;
            case 612:
                return SLEET_2;
            case 611:
                return SLEET_0;
            case 600:
                return SNOW_0;
            case 601:
                return SNOW_1;
            case 602:
                return SNOW_2;
            case 615:
                return SNOW_3;
            case 616:
                return SNOW_4;
            case 620:
                return SNOW_5;
            case 621:
                return SNOW_6;
            case 622:
                return SNOW_7;
            case 500:
                return RAIN_1;
            case 501:
                return RAIN_2;
            case 502:
                return RAIN_3;
            case 503:
                return RAIN_4;
            case 504:
                return RAIN_5;
            case 511:
                return RAIN_6;
            case 520:
                return RAIN_7;
            case 521:
                return RAIN_8;
            case 522:
                return RAIN_9;
            case 531:
                return RAIN_10;
            case 300:
                return DRIZZLE_1;
            case 301:
                return DRIZZLE_2;
            case 302:
                return DRIZZLE_3;
            case 310:
                return DRIZZLE_4;
            case 311:
                return DRIZZLE_5;
            case 312:
                return DRIZZLE_6;
            case 313:
                return DRIZZLE_7;
            case 314:
                return DRIZZLE_8;
            case 321:
                return DRIZZLE_9;
            case 200:
                return THUNDER_1;
            case 201:
                return THUNDER_2;
            case 202:
                return THUNDER_3;
            case 210:
                return THUNDER_4;
            case 211:
                return THUNDER_5;
            case 221:
                return THUNDER_6;
            case 230:
                return THUNDER_7;
            case 231:
                return THUNDER_8;
            case 232:
                return THUNDER_9;
            default:
                return CLEAR;
        }
    }


}
