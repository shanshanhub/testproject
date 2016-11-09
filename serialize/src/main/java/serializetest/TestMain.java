package serializetest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author WanChuanLai
 * @create 9/9/16.
 */
public class TestMain {
    public static void main(String [] args){
        Object saga="rO0ABXNyAD9jb20uY29tYWxsLmN5YmVyc2hvcC5jb21tb24uY29uc2lzdGVuY3kuRXZlbnR1YWxDb25zaXN0ZW5jeVNhZ2EAAAAAAAAAAQIAC0oABWJlZ2luWgARaXNBZ2dyZWdhdGVTdG9yZWRaAA1pc0NhY2hlU3RvcmVkWgAKaXNEQlN0b3JlZFoADWlzSW5kZXhTdG9yZWRaABNuZWVkQWdncmVnYXRlU3RvcmVkWgAPbmVlZENhY2hlU3RvcmVkWgAMbmVlZERCU3RvcmVkWgAPbmVlZEluZGV4U3RvcmVkSQAHb3JkZXJJZEwACWV2ZW50VGltZXQAGExvcmcvam9kYS90aW1lL0RhdGVUaW1lO3hyADxjb20uY29tYWxsLmN5YmVyc2hvcC5jb21tb24uY29uc2lzdGVuY3kuQWJzdHJhY3RTY2hlZHVsZVNhZ2EAAAAAAAAAAQIAAUwADXNjaGVkdWxlVG9rZW50ADpMb3JnL2F4b25mcmFtZXdvcmsvZXZlbnRoYW5kbGluZy9zY2hlZHVsaW5nL1NjaGVkdWxlVG9rZW47eHIAN29yZy5heG9uZnJhbWV3b3JrLnNhZ2EuYW5ub3RhdGlvbi5BYnN0cmFjdEFubm90YXRlZFNhZ2EhGU7YPIYWggIAA1oACGlzQWN0aXZlTAARYXNzb2NpYXRpb25WYWx1ZXN0ACpMb3JnL2F4b25mcmFtZXdvcmsvc2FnYS9Bc3NvY2lhdGlvblZhbHVlcztMAAppZGVudGlmaWVydAASTGphdmEvbGFuZy9TdHJpbmc7eHABc3IAN29yZy5heG9uZnJhbWV3b3JrLnNhZ2EuYW5ub3RhdGlvbi5Bc3NvY2lhdGlvblZhbHVlc0ltcGxy0ibV9OD6wgIAAUwABnZhbHVlc3QAD0xqYXZhL3V0aWwvU2V0O3hwc3IAKGphdmEudXRpbC5jb25jdXJyZW50LkNvcHlPbldyaXRlQXJyYXlTZXRLvdCSkBVp1wIAAUwAAmFsdAArTGphdmEvdXRpbC9jb25jdXJyZW50L0NvcHlPbldyaXRlQXJyYXlMaXN0O3hwc3IAKWphdmEudXRpbC5jb25jdXJyZW50LkNvcHlPbldyaXRlQXJyYXlMaXN0eF2f1UarkMMDAAB4cHcEAAAAAnNyACdvcmcuYXhvbmZyYW1ld29yay5zYWdhLkFzc29jaWF0aW9uVmFsdWUxmEw8B0AMvQIAAkwAC3Byb3BlcnR5S2V5cQB+AAZMAA1wcm9wZXJ0eVZhbHVlcQB+AAZ4cHQADnNhZ2FJZGVudGlmaWVydAAkZmIxY2RjMDktZTE4Mi00MDk2LTk0MTItZWJhZjU2MWRlYTc5c3EAfgAQdAANdHJhbnNhdGlvbktleXQAFENSRUFURU9SREVSNDc3MDE2MDMzeHEAfgATc3IARW9yZy5heG9uZnJhbWV3b3JrLmV2ZW50aGFuZGxpbmcuc2NoZWR1bGluZy5xdWFydHouUXVhcnR6U2NoZWR1bGVUb2tlbmw5CtGDqe4NAgACTAAPZ3JvdXBJZGVudGlmaWVycQB+AAZMAA1qb2JJZGVudGlmaWVycQB+AAZ4cHQAFEF4b25GcmFtZXdvcmstRXZlbnRzdABAZXZlbnQtVHJhbnNhdGlvblRpbWVvdXRFdmVudGM4MGZmZjY1LWE5MTEtNGMxYy1hZDQ2LWZhZDNkNTgxODk1YgAAAVcNKePaAAEAAQEAAQAcbq/hc3IAFm9yZy5qb2RhLnRpbWUuRGF0ZVRpbWW4PHhkalvd+QIAAHhyAB9vcmcuam9kYS50aW1lLmJhc2UuQmFzZURhdGVUaW1l///54U9dLqMCAAJKAAdpTWlsbGlzTAALaUNocm9ub2xvZ3l0ABpMb3JnL2pvZGEvdGltZS9DaHJvbm9sb2d5O3hwAAABVw0pu8pzcgAnb3JnLmpvZGEudGltZS5jaHJvbm8uSVNPQ2hyb25vbG9neSRTdHViqcgRZnE3UCcDAAB4cHNyAB9vcmcuam9kYS50aW1lLkRhdGVUaW1lWm9uZSRTdHVipi8BmnwyGuMDAAB4cHcPAA1Bc2lhL1NoYW5naGFpeHg=";
        byte[] serializedSaga =toByteArray (saga);
        try {
            String strSerializedSaga=new String(serializedSaga,"gb2312");
            System.out.println(strSerializedSaga);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        System.out.println(toByteArray (saga));


    }


    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
}
