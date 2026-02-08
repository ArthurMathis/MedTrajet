package medtrajet.backend.core;

public interface Converter<Model, DTO> {

    /**
     * Public method that converts a DTO to a Model
     *
     * @param dto The DTO
     * @return The new Model
     */
    public Model fromDto(DTO dto);

    /**
     * Public method that converts a Model to a DTO
     *
     * @param model The Model
     * @return The new DTO
     */
    public DTO toDto(Model model);


}
