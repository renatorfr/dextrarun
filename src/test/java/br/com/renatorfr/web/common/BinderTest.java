package br.com.renatorfr.web.common;

import br.com.renatorfr.entity.test.AddressEntity;
import br.com.renatorfr.entity.test.PersonEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinderTest {

    @Test
    public void testEmptyParams() throws Exception {
        Binder binder = new Binder("/api/testController/testEmptyParams");
        Object result = binder.invoke("");
        Assert.assertEquals("Invoke method testEmptyParams()", result.toString());
    }

    @Test
    public void testObjectParams() throws Exception {
        Binder binder = new Binder("/api/testController/testObjectParams");
        Object result = binder.invoke("{ id: 2, name: 'Dextra Run', phone: [123, 456], addr: { id: 1, addr: 'Addr' } }");
        Assert.assertEquals(this.createPersonEntity(), result);
    }

    @Test
    public void testArrayParams() throws Exception {
        Binder binder = new Binder("/api/testController/testArrayParams");
        Object result = binder.invoke("[{ id: 2, name: 'Dextra Run', phone: [123, 456], addr: { id: 1, addr: 'Addr' } }, { id: 1, addr: 'Addr' }]");
        Assert.assertEquals("21", result);
    }

    @Test
    public void testSimpleParam() throws Exception {
        Binder binder = new Binder("/api/testController/testSimpleParam/");
        Object result = binder.invoke("10");
        Assert.assertEquals(new Long(10), result);
    }

    @Test
    @Ignore
    public void test() throws Exception {
        Binder binder = new Binder("/api/negotiationController/saveNegotiation");
        Object result = binder.invoke("{'id':'','modality':'INTERNAL','product':'WHEAT_MILL','origin':'BR','portId':'2','cropYear':'2013','operation':'BOUGHT','quantity':'200','execPeriod':'','unitType':'','payment':'','brokerage':'','comment':''}");
        Assert.assertEquals(null, result);
    }

    private PersonEntity createPersonEntity() {
        PersonEntity person = new PersonEntity();
        person.setId(new Long(2));
        person.setName("Dextra Run");
        List<Integer> phone = new ArrayList<Integer>();
        phone.add(123);
        phone.add(456);
        person.setPhone(phone);
        AddressEntity addr = this.createAddressEntity();
        person.setAddr(addr);
        return person;
    }

    private AddressEntity createAddressEntity() {
        AddressEntity addr = new AddressEntity();
        addr.setId(new Long(1));
        addr.setAddr("Addr");
        return addr;
    }

}
