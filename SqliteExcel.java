public class SqliteExcel {

    //Metodo para exportar dados para excel 01
    public void sqliteParaExcel (List<Tarefa> listaTarefa) {

        //criando cabeçalhos
        String colunas = " \" PRODUTO \" , \" COD-BARRA \"";

        File root = Environment.getExternalStorageDirectory();  //pega o cartão SD
        File pasta = new File(root.getAbsolutePath()); //pçega o caminho do cartão
        pasta.mkdir(); //criando pasta


        File arquivoXLS = new File(pasta, "ListaDeTarefas.xls"); //criar o arquivo inicializado

        FileOutputStream streamSaida = null;

        //preprando o stream de saida
        try {
            streamSaida = new FileOutputStream(arquivoXLS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //depois de preparado escrever no arquivo
        try {
            streamSaida.write(colunas.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //interar a lista
        for (Tarefa tarefa : listaTarefa) { //for percorre pelo quantidade das tarefas inseridas

            String dadosdaTarefas = " \n" + "\"" + tarefa.getNomeTarefa() + "\" , \"" + tarefa.getCodigoBarra() + "\"";


            try {
                streamSaida.write(dadosdaTarefas.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //fechando o arquivo depois de ter escrito
        try {
            streamSaida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
