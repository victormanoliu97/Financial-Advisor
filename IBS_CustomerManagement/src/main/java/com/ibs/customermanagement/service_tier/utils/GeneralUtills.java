package com.ibs.customermanagement.service_tier.utils;

import java.util.Random;

public class GeneralUtills {

    public String generateIban() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RO");
        stringBuilder.append(new Random().nextInt(90)+10);
        stringBuilder.append(new Random().nextInt(10)+1000000000);
        return String.valueOf(stringBuilder);
    }
}
