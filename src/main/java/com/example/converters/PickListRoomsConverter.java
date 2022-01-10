package com.example.converters;

import com.example.entities.RoomEntity;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "PickListRoomsConverter")
public class PickListRoomsConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
        DualListModel<RoomEntity> model = (DualListModel<RoomEntity>) ((PickList) comp).getValue();
        for (RoomEntity pro : model.getSource()) {
            if (String.valueOf(pro.getId()).equals(value)) {
                return pro;
            }
        }
        for (RoomEntity pro : model.getTarget()) {
            if (String.valueOf(pro.getId()).equals(value)) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent comp, Object value) {
        return String.valueOf(((RoomEntity) value).getId());
    }
}