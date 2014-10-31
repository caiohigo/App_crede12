package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Participante;

@FacesConverter(value="participanteConverter", forClass=Participante.class)
public class ParticipanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				ParticipanteDAO dao = new ParticipanteJPADAO();
				Integer id = Integer.parseInt(value);
				System.out.println(dao.find(id));
				return dao.find(id);
			} catch (Exception ex) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid participante."));
			}

		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		Participante participante = (Participante) object;
		if (object != null) {
			return String.valueOf(participante.getId());
		} else {
			return null;
		}
	}

}
