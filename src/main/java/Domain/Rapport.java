package Domain;

public class Rapport {
    private String rapport;
    private String header;
    private String footer;

    public Rapport(String rapport) {
        this.rapport = rapport;
    }

    public String getRapport() {
        StringBuilder stringBuilder = new StringBuilder();
        if(header != null){
            stringBuilder.append("Header: ");
            stringBuilder.append(header);
            stringBuilder.append("\n" );
        }
        stringBuilder.append(rapport);
        stringBuilder.append("\n" );
        if(footer != null){
            stringBuilder.append("Footer: ");
            stringBuilder.append(footer);
        }

        return stringBuilder.toString();
    }


    public void setHeader(String header) {
        this.header = header;
    }


    public void setFooter(String footer) {
        this.footer = footer;
    }
}
