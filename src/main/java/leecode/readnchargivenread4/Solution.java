package leecode.readnchargivenread4;
/*  	Read N Characters Given Read4 */
class Reader4 {
      public int read4(char[] buf) { return 1;} 
}
public class Solution extends Reader4 {
   /**
    * @param buf Destination buffer
    * @param n   Maximum number of characters to read
    * @return    The number of characters read
    */
   public int read4(char[] buf, int n) {
      char[] buffer = new char[4];
      int readBytes = 0;
      boolean eof = false;
      while (!eof && readBytes < n) {
          int sz = read4(buffer);
          if (sz < 4) eof = true;
          int bytes = Math.min(n - readBytes, sz); 
          System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
          readBytes += bytes;
      }
      return readBytes;
   }
}