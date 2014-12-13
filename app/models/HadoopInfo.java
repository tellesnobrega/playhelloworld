package models;

import java.util.*;
import play.data.validation.Constraints.*;

public class HadoopInfo {

  @Required
  public String info;

  public static void submit(HadoopInfo info) {
  }

}
