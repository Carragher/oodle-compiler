#include <syscall.h>


void writeint(int num) {
  char buf[20];
  char result[20] = "0\n";
  char *pos = buf;
  char *writeptr = result;
  int numWritten;
 
  // Handle negative numbers
  if (num < 0) {
    *writeptr++ = '-';
    num = -num;
  }
  
  if (num > 0) {
      
    // Build the number in reverse order
    while (num > 0) {
      *pos++ = (num % 10) + '0';
      num /= 10;
    }
    pos--;
    
    // Now we need to copy the results into the output buffer, reversed
    while (pos > buf) {
      *writeptr++ = *pos--;
    }
    *writeptr++ = *pos;
    *writeptr++ = 10;
    *writeptr++ = 0;
  } else {
    // number is 0; use default result
    writeptr = result + 3;
  }
  
  write(1, result, (writeptr - result) - 1);
  
}




int readint(){
    char buf[1];
    int i = 0;
    int sign  = 1;
    int firstNum = 0;
    int num = 0;
    read(0, buf, 1);
    while(buf[0] != '\n')
    {

      if (buf[0] == '-' && firstNum == 0)
      {
        sign = sign * -1;
      }
      else if(buf[0] >= '0' && buf[0] <= '9')
      {
        num = num * 10 + (buf[0] - '0');
        firstNum = 1;
      }
      else
      {
        write(1, "Error: invalid number\n", 23);
        return 0;
      }
      read(0, buf, 1);
    }
    return num * sign;

}



