package dto;

import java.lang.reflect.Field;

public class DTOConverter
{
    public static DTO convert(Object fromEntity, DTO toDto)
    {
        try{
            for (Field dtoField : toDto.getClass().getDeclaredFields()) {
                Field entityFieldValue = fromEntity.getClass().getDeclaredField(dtoField.getName());
                if (dtoField.getType() != entityFieldValue.getType()) {
                    Object o = entityFieldValue.get(fromEntity);
                    Field identityField = o.getClass().getDeclaredField("id");
                    identityField.setAccessible(true);
                    dtoField.set(toDto,  identityField.get(o));
                    continue;
                }
                entityFieldValue.setAccessible(true);
                dtoField.setAccessible(true);
                dtoField.set(toDto,  entityFieldValue.get(fromEntity));
            }

            return toDto;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return null;
    }
}
