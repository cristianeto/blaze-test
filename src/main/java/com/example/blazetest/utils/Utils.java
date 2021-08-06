package com.example.blazetest.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
  static Utils utils;

  public static Utils getInstanceUtils() {
    if (utils == null) {
        utils = new Utils();
    }
    return utils;
}


  public static Double RoundToTwoDecimalPlaces(Double dblNumero) {    
      BigDecimal bigDecimalNumber = new BigDecimal(dblNumero).setScale(2, RoundingMode.HALF_UP);
      Double roundedNumber = bigDecimalNumber.doubleValue();
      return roundedNumber;
}


}
