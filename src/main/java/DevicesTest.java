import Device.Device;
import Tools.ToolsVersion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DevicesTest {

    public static void main(String[] args) {
        //Testing
        ArrayList<Device> test = new ArrayList<Device>();
        test.add(new Device("1", "7.00"));
        test.add(new Device("2", "7.10.0"));
        test.add(new Device("3", "6.4.2"));
        test.add(new Device("4", "7.10.0.1"));
        test.add(new Device("5", "7.100.0"));
        List<Device> res = ToolsVersion.sortVersion(test);


        for (Iterator iter = res.iterator(); iter.hasNext(); ) {
            Device dev = (Device) iter.next();
            System.out.println("version = " + dev.getVersion() + " name: " + dev.getNameDevice());
        }
    }
}
