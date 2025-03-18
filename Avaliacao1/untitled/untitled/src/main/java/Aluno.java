import jakarta.persistence.*;


@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ra;
    private String email;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno() {}

    public Aluno(String nome, String ra, String email, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public Long getId() {
        return id;
    }
    //nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //ra
    public String getRa(){return ra;}
    public void setRa(String ra) {this.ra = ra;}

    //email
    public String getEmail(){return email;}
    public void setEmail(String email) {this.email = email;}

    //nota 1
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    //nota 2
    public double getNota2() {return nota2;}
    public void setNota2(double nota2) {this.nota2 = nota2;}

    //nota 3
    public double getNota3() {return nota3;}

    public void setNota3(double nota3) {this.nota3 = nota3;}

    public String getStatus() {
        double media = (nota1 + nota2 + nota3) / 3;
        if (media < 4) {
            return "Reprovado";
        } else if (media >= 4 && media < 6) {
            return "Recuperação";
        } else {
            return "Aprovado";
        }
    }

    public double getMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    @Override
    public String toString() {
        return "Dados do Aluno: Id: " + id + " | Nome: " + nome + " | E-mail: " + email + " | RA: " + ra + " | Nota 1: " + nota1 + " | Nota 2: " + nota2 + " | Nota 3: " + nota3 + " | Média: " + getMedia() + " | Situação: " + getStatus();
    }
}