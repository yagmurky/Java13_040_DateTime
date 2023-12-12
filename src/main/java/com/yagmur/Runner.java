package com.yagmur;

import java.time.*;
import java.util.Date;
import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        /**
         *1- doğum günü tutmak
         * 2- ürün ekleme tarihi
         * 3- satışın gerçekleştiği tarih
         * 4- bilgilerin işlendiği tarihler, createAt, updateAt
         */

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDay());
        System.out.println(date.getTime());
        System.out.println(date.toGMTString());

        /**
         * Long
         */

        long currentTimeStamp = System.currentTimeMillis();
        long currentTime = new Date().getTime();
        System.out.println("System..... " + currentTimeStamp);
        System.out.println("Date....... " + currentTime);

        Long dateL = 1702285663692L;
        System.out.println(new Date(dateL));


        /**
         * Date yerine
         * LocalDate, localTime, LocalDateTime, ZonedDateTime
         */

        System.out.println("new Date.........:" + new Date());
        System.out.println("LocalDate........:" + LocalDate.now());
        System.out.println("LocalTime........:" + LocalTime.now());
        System.out.println("LocalDateTime....:" + LocalDateTime.now());
        System.out.println("ZonedDateTime....:" + ZonedDateTime.now());

        //------------------------------------------------------------
        LocalDate localDate = LocalDate.of(2020,12,31);
        localDate = LocalDate.of(2023, Month.MARCH,14);
        System.out.println(localDate);
        LocalTime localTime =LocalTime.of(23,59,59,6544);
        System.out.println("Elle tanımlanan localTime: " + localTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate,localTime,ZoneId.of("Europe/Istanbul"));
        System.out.println("Elle tanımlanan zonedDateTime: " + zonedDateTime);

        zonedDateTime = ZonedDateTime.of(2028,11,20,19,45,55,2,ZoneId.of("Asia/Istanbul"));
        System.out.println("Elle tanımlanan zonedDateTime Asia: " + zonedDateTime);

        System.out.println("18 günde bir şunu yap........: " + localDate.plusDays(18));
        System.out.println("2 hafta sonrası..............: " + localDate.plusWeeks(2));
        System.out.println("3 ay sonrası.................: " + localDate.plusMonths(3));
        System.out.println("4 gün öncesi.................: " + localDate.minusDays(4));
        System.out.println("1 saat sonrası...............: " + localTime.plusHours(1));
        System.out.println("4 saat öncesi................: " + localTime.minusHours(4));
        localDate = LocalDate.of(2023,05,15);
        System.out.println("Elle tanımlanan localDate...: " + localDate);
        System.out.println("12 gün sonrası..............: " + localDate.plusDays(12));
        System.out.println("Elle tanımlanan localDate...: " + localDate);

        /**
         *   "P2Y"             -- Period.ofYears(2)
         *     "P3M"             -- Period.ofMonths(3)
         *     "P4W"             -- Period.ofWeeks(4)
         *     "P5D"             -- Period.ofDays(5)
         *     "P1Y2M3D"         -- Period.of(1, 2, 3)
         *     "P1Y2M3W4D"       -- Period.of(1, 2, 25)
         *     "P-1Y2M"          -- Period.of(-1, 2, 0)
         *     "-P1Y2M"          -- Period.of(-1, -2, 0)
         *
         */

        Period period = Period.parse("P3M");
        System.out.println("3 ay sonrası................: " +localDate.plus(period));
        System.out.println("Elle tanımlanan LocalDate...: " + localDate);
        period = Period.ofDays(20);
        System.out.println("20 gün sonrası..............: " +localDate.plus(period));
        System.out.println("Elle tanımlanan LocalDate...: " + localDate);

        /**
         * Belirli bir kodun çalışma zamanını ölçmek için kullanabileceğimiz bir çok yöntem vardır.
         * Bunlardan birisi içinde bulunduğumuz zamanı almak ve aradaki farkı çıkartmak.
         */

        long start1 = System.currentTimeMillis();
        long start2 = System.nanoTime();
        Instant instant_start = Instant.now();
        long toplam=0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            toplam+=i;
        }
        System.out.println("Toplam: " + toplam);
        long end1 = System.currentTimeMillis();
        long end2 = System.nanoTime();
        Instant instant_end = Instant.now();

        System.out.println("Geçen süre ms: " + (end1-start1));
        System.out.println("Geçen süre ns: " + (end2-start2));

        Duration duration = Duration.between(instant_start,instant_end);
        System.out.println("Geçen süre ms: " + duration.toMillis());
        System.out.println("Geçen süre ns: " + duration.toNanos());
    }
}
