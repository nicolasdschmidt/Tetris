package bd.dbos;

public class Pontuacao implements Cloneable
{
    private String user;
    private int score;

    public void setUser (String user) throws Exception
    {
        if (user == null || user.equals(""))
            throw new Exception ("Usuario nao fornecido");

        this.user = user;
    }

    public void setScore (int score) throws Exception
    {
        if (score <= 0)
            throw new Exception ("Pontuacao invalida");

        this.score = score;
    }

    public String getUser ()
    {
        return this.user;
    }

    public int getScore ()
    {
        return this.score;
    }

    public Pontuacao (String user, int score) throws Exception
    {
        this.setUser   (user);
        this.setScore  (score);
    }

    public String toString ()
    {
        String ret = "";

        ret += "Usuario..: " + this.user +"\n";
        ret += "Pontuacao: " + this.score;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Pontuacao))
            return false;

        Pontuacao aPontuacao = (Pontuacao)obj;

        if (this.user.equals(aPontuacao.user))
            return false;

        if (this.score != aPontuacao.score)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret = 666;

        ret = 7 * ret + this.user.hashCode();
        ret = 7 * ret + new Integer(this.score).hashCode();

        return ret;
    }


    public Pontuacao (Pontuacao modelo) throws Exception
    {
        this.user   = modelo.user;   // nao clono, pq nao eh clonavel
        this.score  = modelo.score;  // nao clono, pq nao eh objeto
    }

    public Object clone ()
    {
    	Pontuacao ret = null;

        try
        {
            ret = new Pontuacao (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}