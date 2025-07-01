package model.enums;

public enum StatusJogo {
    NAO_INICIADO("não iniciado"),
    INCOMPLETO("incompleto"),
    COMPLETO("completo");

    private String label;

    StatusJogo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
