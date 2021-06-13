package projeto.zup.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class ModeloResponse {
	List<ModeloResponseObjeto> modelos;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public ModeloResponse(List<ModeloResponseObjeto> modelos) {
		this.modelos = modelos;
	}

	public List<ModeloResponseObjeto> getModelosResponse() {
		return modelos;
	}

	public void setModelosResponse(List<ModeloResponseObjeto> modelosResponse) {
		this.modelos = modelosResponse;
	}
	
}
