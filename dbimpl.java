package Main;

/**
 *  Database Systems - HEAP IMPLEMENTATION
 */

public interface dbimpl
{

   public static final String HEAP_FNAME = "heap.";
   public static final String ENCODING = "utf-8";

   // fixed/variable lengths
   public static final int RECORD_SIZE = 336;
   public static final int EOF_PAGENUM_SIZE = 4;
   public static final int RID_SIZE = 4;

   public static final int DEVICE_ID_SIZE = 6;
   public static final int ARRIVAL_TIME_SIZE = 22;
   public static final int DEPART_TIME_SIZE = 22;
   public static final int DURATION_SIZE = 20;
   public static final int STREET_MARKER_SIZE = 12;
   public static final int SIGN_SIZE = 50;
   public static final int AREA_SIZE = 20;
   public static final int STREET_ID_SIZE = 10;
   public static final int STREET_NAME_SIZE = 50;
   public static final int BETWEEN_STREET_1_SIZE = 50;
   public static final int BETWEEN_STREET_2_SIZE = 50;
   public static final int SIDE_OF_STREET_SIZE = 1;
   public static final int VIOLATION_SIZE = 5;

   public static final int ARRIVAL_TIME_OFFSET = RID_SIZE
                                                 + DEVICE_ID_SIZE;

   public static final int DEPART_TIME_OFFSET = RID_SIZE 
                                                + DEVICE_ID_SIZE
                                                + ARRIVAL_TIME_SIZE;

   public static final int DURATION_OFFSET = RID_SIZE 
                                             + DEVICE_ID_SIZE
                                             + ARRIVAL_TIME_SIZE
                                             + DEPART_TIME_SIZE;

   public static final int STREET_MARKER_OFFSET = RID_SIZE 
                                             + DEVICE_ID_SIZE
                                             + ARRIVAL_TIME_SIZE
                                             + DEPART_TIME_SIZE
                                             + DURATION_SIZE;

   public static final int SIGN_OFFSET = RID_SIZE 
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE;

   public static final int AREA_OFFSET = RID_SIZE 
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE;

   public static final int STREET_ID_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE;

   public static final int STREET_NAME_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE
                                         + STREET_ID_SIZE;

   public static final int BETWEEN_STREET_1_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE
                                         + STREET_ID_SIZE
                                         + STREET_NAME_SIZE;

   public static final int BETWEEN_STREET_2_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE
                                         + STREET_ID_SIZE
                                         + STREET_NAME_SIZE
                                         + BETWEEN_STREET_1_SIZE;

   public static final int SIDE_OF_STREET_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE
                                         + STREET_ID_SIZE
                                         + STREET_NAME_SIZE
                                         + BETWEEN_STREET_1_SIZE
                                         + BETWEEN_STREET_2_SIZE;

   public static final int VIOLATION_OFFSET = RID_SIZE
                                         + DEVICE_ID_SIZE
                                         + ARRIVAL_TIME_SIZE
                                         + DEPART_TIME_SIZE
                                         + DURATION_SIZE
                                         + STREET_MARKER_SIZE
                                         + SIGN_SIZE
                                         + AREA_SIZE
                                         + STREET_ID_SIZE
                                         + STREET_NAME_SIZE
                                         + BETWEEN_STREET_1_SIZE
                                         + BETWEEN_STREET_2_SIZE
                                         + SIDE_OF_STREET_SIZE;

   public void readArguments(String args[]);

   public boolean isInteger(String s);
}

