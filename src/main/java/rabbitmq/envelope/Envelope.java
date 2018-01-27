package rabbitmq.envelope;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Envelope implements Serializable
{

    public static Object createFromObject(Object fromObject, Class<?>  to)
    {
        try{
            Object toObject = Class.forName(to.getName()).newInstance();

            for (Field envelopeField : toObject.getClass().getDeclaredFields()) {
                Field entityFieldValue = fromObject.getClass().getDeclaredField(envelopeField.getName());
                if (envelopeField.getType() != entityFieldValue.getType()) {
                    Object o = entityFieldValue.get(fromObject);
                    Field identityField = o.getClass().getDeclaredField("id");
                    identityField.setAccessible(true);
                    envelopeField.set(toObject,  identityField.get(o));
                    continue;
                }
                envelopeField.set(toObject,  entityFieldValue.get(fromObject));
            }
            return toObject;
        }catch (Exception e){
            System.out.close();
        }

        return  null;
    }
}
