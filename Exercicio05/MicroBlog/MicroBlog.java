package Exercicio05.MicroBlog;
import java.util.List;
import java.util.ArrayList;


public class MicroBlog {
    List<Postagem> postagens = new ArrayList<Postagem>();

    public void adicionarPostagem(Postagem postagem){
        postagens.add(postagem);
    }

    public int consultarIndicePostagem(int id){
        int indiceProcurado = -1;

        for (int i = 0; i < postagens.size(); i++){
            if (postagens.get(i).id == id){
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado; 
    }

    public void excluir(int id){
       int indiceDesejado = consultarIndicePostagem(id);

       if (indiceDesejado != -1){
        for(int i = indiceDesejado; i < postagens.size(); i++){
            postagens.set(i, postagens.get(i+1));
        }

        postagens.remove(postagens.size() - 1);
       }
    }

    public String postagemMaisCurtida(){
        Postagem maisCurtida = postagens.get(0);

        for (Postagem postagem : postagens) {
            if(postagem.quantidadeCurtidas > maisCurtida.quantidadeCurtidas){
                maisCurtida = postagem;
            }
        }

        return maisCurtida.toString();
    }

    public void curtir(int id){
        int indiceDesejado = consultarIndicePostagem(id);
        
        postagens.get(indiceDesejado).curtir();
    }

    public String toString(){
        String postagensString = null;
        for (Postagem postagem : postagens) {
            postagensString += postagem.toString() + "\n";
        }

        return postagensString;
    }
}
