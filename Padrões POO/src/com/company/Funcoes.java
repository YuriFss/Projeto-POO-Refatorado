package com.company;

import com.Command.Command;
import com.Command.Commander;
import com.Strategy.HashOptions;
import com.Strategy.MenuOption;

import java.util.Scanner;

public class Funcoes {

    public static Folha folha = new Folha();
    static Scanner in = new Scanner(System.in);
    static int sem = 1;
    static Exception exc = new FPexc();


    public static void zerarContabilizar() {
        int i;
        double hor;
        for (i = 0; i < folha.ListaFuncionarios.size(); i++) {
            if (folha.ListaFuncionarios.get(i) instanceof Horista) {
                hor = folha.ListaFuncionarios.get(i).getHj();
                if (hor > 8) hor = hor * 1.5;//contabiliza 1.5
                folha.ListaFuncionarios.get(i).setHorw(folha.ListaFuncionarios.get(i).getHorw() + hor);
                folha.ListaFuncionarios.get(i).setHj(0);
            } else {
                folha.ListaFuncionarios.get(i).setDiaw(folha.ListaFuncionarios.get(i).getDiaw() + (int) folha.ListaFuncionarios.get(i).getHj());
                folha.ListaFuncionarios.get(i).setHj(0);
            }
        }
    }

    public static boolean findDay(int a[], int dia) {
        int i;
        for (i = 0; i < 5; i++) if (dia == a[i]) return true;
        return false;
    }


    public static void printFunc(int id) {
        int i = findFunc(id);
        if (i != -1) {
            Funcionario aux = folha.ListaFuncionarios.get(i);
            System.out.println(aux.toString());
        } else System.out.print("Não Encontrado!\n");
    }


    public static void ListarFuncionarios() {
        if (folha.ListaFuncionarios.isEmpty()) System.out.print("Não existem Funcionários cadastrados!\n");
        else {
            for (int i = 0; i < folha.ListaFuncionarios.size(); i++)
                System.out.print(folha.ListaFuncionarios.get(i).toString());
        }
    }

    public static int findFunc(int id) {
        int i;
        for (i = 0; i < folha.ListaFuncionarios.size(); i++) {
            if (folha.ListaFuncionarios.get(i).getId() == id) {
                System.out.print("Funcionário encontrado!\n");
                return i;
            }
        }
        System.out.print("Funcionário não encontrado!\n");
        return -1;
    }


    public static void addFuncionario() {
        int option;

        System.out.println("Deseja Continuar? [1] Para sim, [0] para não.\n");

        option = exc.loadintmargin(0, 1);
        if (option != 1) return;
        else {

            System.out.println("Digite o nome do funcionário: ");
            String nome = in.nextLine();
            System.out.println("Digite o endereço do funcionário: ");
            String endereco = in.nextLine();
            Funcionario novo;


            System.out.print("Selecione o tipo de empregado: [1] - Horista || [2] - Assalariado || [3] Comissionado.\n");
            option = exc.loadintmargin(1, 3);
            if (option == 1) {
                System.out.print("Horista\n");
                novo = new Horista(nome, endereco);
            } else if (option == 2) {
                System.out.print("Assalariado\n");
                novo = new Assalariado(nome, endereco);

            } else {
                System.out.print("Comissionado\n");
                novo = new Comissionado(nome, endereco);
            }

            System.out.print("O método de pagamento é mensalmente, ao final do mês.\n");
            int a[] = {31, 0, 0, 0, 0};
            novo.setPaymentdays(a);


            //System.out.printf("Tipo %.2s, salario hora %.2f, salario mensal %.2f, comissao %.2f.\n", novo.getTipostr(), novos.getSalhor(), novos.getSalmen(), novos.getComis());//teste
            folha.ListaFuncionarios.add(novo);
            System.out.print("Funcionário cadastrado com sucesso!\n");

        }
    }

    public static Funcionario delFuncionario() {
        ListarFuncionarios();

        Funcionario aux;
        int id, option, i;
        System.out.print("Digite o ID do funcionário a ser removido: ");
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente remover o funcionário? 1 - [S] || 0 - [N].\n");
            option = exc.loadintmargin(0, 1);
            if (option == 1) {
                aux = folha.ListaFuncionarios.remove(i);
                System.out.print("Funcionário removido com sucesso!\n");
                return aux;
            }
        } else System.out.print("Não Encontrado!\n");
        return null;
    }

    public static void lancarPonto() {
        System.out.print("Digite o ID do funcionário para ser lançado o ponto: ");
        int id, i, option;
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente lançar o ponto? 1 - [S] || 0 - [N].\n");
            printFunc(id);
            option = exc.loadintmargin(0, 1);
            if (option == 1) {

                if (folha.ListaFuncionarios.get(i) instanceof Horista) {
                    System.out.print("O funcionário é Horista, digite a quantidade de horas trabalhadas: ");
                    folha.ListaFuncionarios.get(i).setHj(folha.ListaFuncionarios.get(i).getHj() + exc.loaddouble());
                    System.out.print("Se excedido 8 horas diárias, cada hora a mais irá custar 50% a mais.\n");
                } else if (folha.ListaFuncionarios.get(i) instanceof Assalariado || folha.ListaFuncionarios.get(i) instanceof Comissionado) {
                    if (folha.ListaFuncionarios.get(i).getHj() == 1)
                        System.out.print("Ponto já registrado para este funcionário hoje.");
                    else {
                        System.out.print("O funcionário é Assalariado ou Comissionado, Trabalhou o dia de hoje? [1] para Sim, [0] para Não.\nSe sim um dia de trabalho será incrementado.");
                        option = exc.loadintmargin(0, 1);
                        if (option == 1) folha.ListaFuncionarios.get(i).setHj(1);
                    }
                }
            }

        } else System.out.print("Não Encontrado!\n");
    }


    public static void lancarVenda() {
        System.out.print("Digite o ID do funcionário para ser lançada a venda: ");
        int id, i, option;
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente lançar a venda? 1 - [S] || 0 - [N].\n");
            printFunc(id);
            option = exc.loadintmargin(0, 1);
            if (option == 1) {

                if (folha.ListaFuncionarios.get(i) instanceof Comissionado) {
                    System.out.print("Funcionário comissionado!\nDigite o valor da venda: ");
                    Salario aux = folha.ListaFuncionarios.get(i).getSalario();
                    aux.setVendas(aux.getVendas() + exc.loaddouble());
                    folha.ListaFuncionarios.get(i).setSalario(aux);
                    printFunc(id);
                } else System.out.print("Funcionário não comissionado!\n");
            }
        } else System.out.print("Não Encontrado!\n");
        //else System.out.print("Funcionário não comissionado!\n");
    }

    public static void lancarTaxas() {
        System.out.print("Digite o ID do funcionário para ser lançada a taxa de serviço: ");
        int id, i, option;
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente lançar a taxa de serviço? 1 - [S] || 0 - [N].\n");
            printFunc(id);
            option = exc.loadintmargin(0, 1);
            if (option == 1) {

                System.out.print("Digite o valor da taxa de serviço: ");
                Salario aux = folha.ListaFuncionarios.get(i).getSalario();
                aux.setTaxas(aux.getTaxas() + exc.loaddouble());
                folha.ListaFuncionarios.get(i).setSalario(aux);
                printFunc(id);
            }
        } else System.out.print("Funcionário não comissionado!\n");
    }

    public static void editFunc() {
        System.out.print("Digite o ID do funcionário a ser editado: ");
        int id, i, option;
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente editar os dados do funcionário? 1 - [S] || 0 - [N].\n");
            printFunc(id);
            option = exc.loadintmargin(0, 1);
            if (option == 1) {

                System.out.print("Deseja editar o nome do funcionário? 1 - [S] || 0 - [N].\n");
                option = exc.loadintmargin(0, 1);
                in.nextLine();
                if (option == 1) {
                    System.out.print("Digite o novo nome:\n");
                    folha.ListaFuncionarios.get(i).setNome(in.nextLine());
                }
                System.out.print("Deseja editar o endereço do funcionário? 1 - [S] || 0 - [N].\n");
                option = exc.loadintmargin(0, 1);
                in.nextLine();
                if (option == 1) {
                    System.out.print("Digite o novo endereço:\n");
                    folha.ListaFuncionarios.get(i).setEndereco(in.nextLine());
                }
                System.out.print("Deseja editar o tipo do funcionário? 1 - [S] || 0 - [N].\n");
                option = exc.loadintmargin(0, 1);
                //in.nextLine();
                if (option == 1) {
                    Funcionario novo;
                    System.out.print("Selecione o tipo de empregado: [1] - Horista || [2] - Assalariado || [3] Comissionado.\n");
                    option = exc.loadintmargin(1, 3);
                    if (option == 1) {
                        System.out.print("[Horista] - Funcionário Será Pago!\n");
                        novo = new Horista(folha.ListaFuncionarios.get(i).getId(), folha.ListaFuncionarios.get(i).getNome(), folha.ListaFuncionarios.get(i).getEndereco());
                    } else if (option == 2) {
                        System.out.print("[Assalariado] - Funcionário Será Pago!\n");
                        novo = new Assalariado(folha.ListaFuncionarios.get(i).getId(), folha.ListaFuncionarios.get(i).getNome(), folha.ListaFuncionarios.get(i).getEndereco());
                    } else {
                        System.out.print("[Comissionado] - Funcionário Será Pago!\n");
                        novo = new Comissionado(folha.ListaFuncionarios.get(i).getId(), folha.ListaFuncionarios.get(i).getNome(), folha.ListaFuncionarios.get(i).getEndereco());
                    }
                    System.out.print("O método de pagamento é mensalmente, ao final do mês.\n");
                    int a[] = {31, 0, 0, 0, 0};
                    novo.setPaymentdays(a);
                    folha.ListaFuncionarios.set(i, novo);
                }
            }

        } else System.out.print("Funcionário não comissionado!\n");

    }

    public static void rodarFphj() {
        System.out.print("Rodando a folha de pagamento para hoje...\n");
        int i;
        for (i = 0; i < folha.ListaFuncionarios.size(); i++) {
            if (findDay(folha.ListaFuncionarios.get(i).getPaymentdays(), folha.dia)) {
                System.out.printf("Funcionário a ser pago: ");
                printFunc(folha.ListaFuncionarios.get(i).getId());
                System.out.printf("Dias Trabalhados: %d\nSalário Mensal %.2f\n", folha.ListaFuncionarios.get(i).getDiaw(), folha.ListaFuncionarios.get(i).getSalario().getSalmen());
                System.out.printf("Horas Trabalhadas: %.2f\nSalário Hora %.2f\n", folha.ListaFuncionarios.get(i).getHorw(), folha.ListaFuncionarios.get(i).getSalario().getSalhor());
                Salario aux = folha.ListaFuncionarios.get(i).getSalario();
                aux.setSaltot((folha.ListaFuncionarios.get(i).getHorw() * aux.getSalhor()) + (((double) folha.ListaFuncionarios.get(i).getDiaw() / 27) * aux.getSalmen()) + (aux.getVendas() * (aux.getComis() / 100)));
                System.out.printf("Salário Bruto = %.2f\n", aux.getSaltot());                                               ///CONSIDERANDO UM MES COM 27 DIAS UTEIS - 4 DOMINGOS.
                System.out.printf("Taxas = %.2f\n", aux.getTaxas());
                System.out.printf("Sindicato(2%%) =  %.2f\n", aux.getSaltot() * 0.02);
                aux.setSaltot(aux.getSaltot() - aux.getTaxas() - aux.getSaltot() * 0.02);
                System.out.printf("Salário Líquido = %.2f\n", aux.getSaltot());
                aux.setTaxas(0);
                aux.setVendas(0);
                if (folha.ListaFuncionarios.get(i) instanceof Horista)//RESETANDO ATRIBUTOS, CASO O FUNCIONARIO TENHA MUDADO DE TIPO
                {
                    folha.ListaFuncionarios.get(i).getSalario().setSalmen(0);
                    folha.ListaFuncionarios.get(i).getSalario().setComis(0);
                } else if (folha.ListaFuncionarios.get(i) instanceof Assalariado || folha.ListaFuncionarios.get(i) instanceof Comissionado) {
                    folha.ListaFuncionarios.get(i).getSalario().setSalhor(0);
                    if (folha.ListaFuncionarios.get(i) instanceof Assalariado)
                        folha.ListaFuncionarios.get(i).getSalario().setComis(0);
                }
                folha.ListaFuncionarios.get(i).setSalario(aux);
                folha.ListaFuncionarios.get(i).setHj(0);
                folha.ListaFuncionarios.get(i).setDiaw(0);
                folha.ListaFuncionarios.get(i).setHorw(0);
            }
        }
    }


    public static void agendaPagamento() {
        System.out.print("Digite o ID do funcionário para mudar a agenda de pagamento: ");
        int id, i, option;
        id = exc.loadint();
        i = findFunc(id);
        if (i != -1) {
            System.out.print("Deseja realmente editar a agenda de pagamento do funcionário? 1 - [S] || 0 - [N].\n");
            //printFunc(ListaFuncionarios, id);
            option = exc.loadintmargin(0, 1);
            //1- semanalmente(1, 8, 15, 22, 29) , 2- bi semanalmente(8, 22), 3- fim do mes(31)
            int p1[] = {1, 8, 15, 22, 29};
            int p2[] = {8, 22, 0, 0, 0};
            int p3[] = {31, 0, 0, 0, 0};
            int aux[];

            aux = folha.ListaFuncionarios.get(i).getPaymentdays();
            int j;
            for (j = 0; j < 5; j++) System.out.printf("%d ", aux[j]);
            System.out.print("\n");

            if (option == 1) {
                System.out.print("Qual agenda deseja?\n[1] - Semanalmente as segundas;\n[2] - Bi-semanalmente as segundas;\n[3] - Mensalmente no último dia do mês.\n");
                option = exc.loadintmargin(1, 3);
                ;
                if (option == 1) {
                    System.out.print("Opção [1]\n");
                    folha.ListaFuncionarios.get(i).setPaymentdays(p1);
                } else if (option == 2) {
                    System.out.print("Opção [2]\n");
                    folha.ListaFuncionarios.get(i).setPaymentdays(p2);

                } else if (option == 3) {
                    System.out.print("Opção [3]\n");
                    folha.ListaFuncionarios.get(i).setPaymentdays(p3);
                }
                aux = folha.ListaFuncionarios.get(i).getPaymentdays();
                for (j = 0; j < 5; j++) System.out.printf("%d ", aux[j]);
                System.out.print("\n");
            }

        } else System.out.print("Funcionário não comissionado!\n");

    }


    public static void menu() {
        int option;
        if (folha.dia < 32) {
            System.out.println("Bem vindo(a) de volta, hoje é dia: ");
            int dsem = folha.dia % 7;
            if (dsem == 0) sem++;

            Commander comma = new Commander();

            if (dsem == 0)
            {
                System.out.println(sem + " Semana | " + folha.dia + " - Domingo.\n");
                folha.dia++;
                menu();
            }
            else
            {
                Command cm =  comma.command(Integer.toString(dsem));//COMMAND
                cm.print(sem, folha.dia);
            }

            System.out.print("Digite:\n");
            System.out.print("[0]  - Sair;\n");
            System.out.print("[1]  - Adicionar Empregado;\n");
            System.out.print("[2]  - Remover Empregado;\n");
            System.out.print("[3]  - Lançar um Cartão de Ponto;\n");
            System.out.print("[4]  - Lançar um Resultado Venda;\n");
            System.out.print("[5]  - Lançar uma taxa de serviço;\n");
            System.out.print("[6]  - Alterar detalhes de um empregado;\n");
            System.out.print("[7]  - Rodar a folha de pagamento para hoje;\n");
            System.out.print("[8]  - Undo/Redo;\n");
            System.out.print("[9]  - Agenda de Pagamento;\n");
            System.out.print("[10] - Criação de Novas Agendas de Pagamento;\n");
            System.out.print("[11] - Listar um funcionário específico.\n");

            option = exc.loadintmargin(0, 11);
            //in.nextLine();

            if( option < 12 && option >= 0)
            {
                HashOptions opt = new HashOptions();
                MenuOption m = opt.item(Integer.toString(option));
                m.option();
            }
            else System.out.print("Opção inválida!\n");

            System.out.print("Deseja fazer outra alteração? Se sim, digite [1], se não digite [0](Sair).\n");
            option = exc.loadintmargin(0, 1);
            //in.nextLine();
            if (option == 1) menu();
            else System.exit(0);
        } else {
            System.out.print("Fim do mês!\nDeseja iniciar outro mês? Se sim, digite [1], se não digite [0](Sair).\n");
            option = exc.loadintmargin(0, 1);
            //in.nextLine();
            if (option == 1) {
                folha.dia = 1;
                menu();
            } else System.exit(0);
        }
    }
}
