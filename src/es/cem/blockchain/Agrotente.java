package es.cem.blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Agrotente extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b5b6113228061001f6000396000f300606060405263ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631f22a90b811461005e5780632755a444146101275780632ba2ab6e146103b1578063ded39a5d1461050c575b600080fd5b341561006957600080fd5b6100af60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061079695505050505050565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100ec5780820151818401525b6020016100d3565b50505050905090810190601f1680156101195780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561013257600080fd5b61013d600435610d5e565b60405160a08082528654600260001961010060018416150201909116049082018190528190602082019060408301906060840190608085019060c08601908c9080156101ca5780601f1061019f576101008083540402835291602001916101ca565b820191906000526020600020905b8154815290600101906020018083116101ad57829003601f168201915b505086810385528a54600260001961010060018416150201909116048082526020909101908b90801561023e5780601f106102135761010080835404028352916020019161023e565b820191906000526020600020905b81548152906001019060200180831161022157829003601f168201915b505086810384528954600260001961010060018416150201909116048082526020909101908a9080156102b25780601f10610287576101008083540402835291602001916102b2565b820191906000526020600020905b81548152906001019060200180831161029557829003601f168201915b50508681038352885460026000196101006001841615020190911604808252602090910190899080156103265780601f106102fb57610100808354040283529160200191610326565b820191906000526020600020905b81548152906001019060200180831161030957829003601f168201915b505086810382528754600260001961010060018416150201909116048082526020909101908890801561039a5780601f1061036f5761010080835404028352916020019161039a565b820191906000526020600020905b81548152906001019060200180831161037d57829003601f168201915b50509a505050505050505050505060405180910390f35b34156103bc57600080fd5b61050a60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528181529291906020840183838082843750949650610d9395505050505050565b005b341561051757600080fd5b61013d600435610e6f565b60405160a08082528654600260001961010060018416150201909116049082018190528190602082019060408301906060840190608085019060c08601908c9080156101ca5780601f1061019f576101008083540402835291602001916101ca565b820191906000526020600020905b8154815290600101906020018083116101ad57829003601f168201915b505086810385528a54600260001961010060018416150201909116048082526020909101908b90801561023e5780601f106102135761010080835404028352916020019161023e565b820191906000526020600020905b81548152906001019060200180831161022157829003601f168201915b505086810384528954600260001961010060018416150201909116048082526020909101908a9080156102b25780601f10610287576101008083540402835291602001916102b2565b820191906000526020600020905b81548152906001019060200180831161029557829003601f168201915b50508681038352885460026000196101006001841615020190911604808252602090910190899080156103265780601f106102fb57610100808354040283529160200191610326565b820191906000526020600020905b81548152906001019060200180831161030957829003601f168201915b505086810382528754600260001961010060018416150201909116048082526020909101908890801561039a5780601f1061036f5761010080835404028352916020019161039a565b820191906000526020600020905b81548152906001019060200180831161037d57829003601f168201915b50509a505050505050505050505060405180910390f35b61079e611156565b6107a6611156565b60008060006020604051908101604052600080825290945092505b600054831015610d5157856040518082805190602001908083835b602083106107fc57805182525b601f1990920191602091820191016107dc565b6001836020036101000a03801982511681845116179092525050509190910192506040915050518091039020915060008381548110151561083957fe5b906000526020600020906005020160005b5060405180828054600181600116156101000203166002900480156108a65780601f106108845761010080835404028352918201916108a6565b820191906000526020600020905b815481529060010190602001808311610892575b5050915050604051908190039020905081811415610d455761099d846000858154811015156108d157fe5b906000526020600020906005020160005b508054600260001961010060018416150201909116046020601f820181900481020160405190810160405280929190818152602001828054600181600116156101000203166002900480156109785780601f1061094d57610100808354040283529160200191610978565b820191906000526020600020905b81548152906001019060200180831161095b57829003601f168201915b5050505050604080519081016040526001815260f960020a601d026020820152610ea4565b9350610a80846000858154811015156109b257fe5b906000526020600020906005020160005b506001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109785780601f1061094d57610100808354040283529160200191610978565b820191906000526020600020905b81548152906001019060200180831161095b57829003601f168201915b5050505050604080519081016040526001815260f960020a601d026020820152610ea4565b9350610b6384600085815481101515610a9557fe5b906000526020600020906005020160005b506002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109785780601f1061094d57610100808354040283529160200191610978565b820191906000526020600020905b81548152906001019060200180831161095b57829003601f168201915b5050505050604080519081016040526001815260f960020a601d026020820152610ea4565b9350610c4684600085815481101515610b7857fe5b906000526020600020906005020160005b506003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109785780601f1061094d57610100808354040283529160200191610978565b820191906000526020600020905b81548152906001019060200180831161095b57829003601f168201915b5050505050604080519081016040526001815260f960020a601d026020820152610ea4565b9350610d4284600085815481101515610c5b57fe5b906000526020600020906005020160005b506004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d045780601f10610cd957610100808354040283529160200191610d04565b820191906000526020600020905b815481529060010190602001808311610ce757829003601f168201915b505050505060408051908101604052600181527f3b000000000000000000000000000000000000000000000000000000000000006020820152610ea4565b93505b5b6001909201916107c1565b8394505b50505050919050565b6001805482908110610d6c57fe5b906000526020600020906005020160005b5090506001810160028201600383016004840185565b6000805460018101610da58382611168565b916000526020600020906005020160005b60a060405190810160409081528982526020820189905281018790526060810186905260808101859052919050815181908051610df792916020019061119a565b50602082015181600101908051610e1292916020019061119a565b50604082015181600201908051610e2d92916020019061119a565b50606082015181600301908051610e4892916020019061119a565b50608082015181600401908051610e6392916020019061119a565b505050505b5050505050565b6000805482908110610d6c57fe5b906000526020600020906005020160005b5090506001810160028201600383016004840185565b610eac611156565b610ed78484846020604051908101604052806000815250602060405190810160405260008152610ee1565b90505b9392505050565b610ee9611156565b610ef1611156565b610ef9611156565b610f01611156565b610f09611156565b610f11611156565b610f19611156565b610f21611156565b6000808e98508d97508c96508b95508a94508451865188518a518c5101010101604051805910610f4e5750595b908082528060200260200182016040525b50935083925060009150600090505b8851811015610fc857888181518110610f8357fe5b016020015160f860020a900460f860020a02838380600101945081518110610fa757fe5b906020010190600160f860020a031916908160001a9053505b600101610f6e565b5060005b875181101561102657878181518110610fe157fe5b016020015160f860020a900460f860020a0283838060010194508151811061100557fe5b906020010190600160f860020a031916908160001a9053505b600101610fcc565b5060005b86518110156110845786818151811061103f57fe5b016020015160f860020a900460f860020a0283838060010194508151811061106357fe5b906020010190600160f860020a031916908160001a9053505b60010161102a565b5060005b85518110156110e25785818151811061109d57fe5b016020015160f860020a900460f860020a028383806001019450815181106110c157fe5b906020010190600160f860020a031916908160001a9053505b600101611088565b5060005b8451811015611140578481815181106110fb57fe5b016020015160f860020a900460f860020a0283838060010194508151811061111f57fe5b906020010190600160f860020a031916908160001a9053505b6001016110e6565b8299505b50505050505050505095945050505050565b60206040519081016040526000815290565b81548183558181151161119457600502816005028360005260206000209182019101611194919061122b565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106111db57805160ff1916838001178555611208565b82800160010185558215611208579182015b828111156112085782518255916020019190600101906111ed565b5b5061121592915061128d565b5090565b60206040519081016040526000815290565b61128a91905b8082111561121557600061124582826112ae565b6112536001830160006112ae565b6112616002830160006112ae565b61126f6003830160006112ae565b61127d6004830160006112ae565b50600501611231565b5090565b90565b61128a91905b808211156112155760008155600101611293565b5090565b90565b50805460018160011615610100020316600290046000825580601f106112d457506112f2565b601f0160209004906000526020600020908101906112f2919061128d565b5b505600a165627a7a723058204b27c0ae72b1667907e791d247e8f05ad1d8f97f0ff8a77812bbeae789cefc6c0029";

    public static final String FUNC_RECUPERADATOBYUSUARIO = "recuperaDatoByUsuario";

    public static final String FUNC_VECTORRESULTADOS = "vectorResultados";

    public static final String FUNC_ENTRADATO = "entraDato";

    public static final String FUNC_REGISTROS = "registros";

    protected Agrotente(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Agrotente(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> recuperaDatoByUsuario(String usuario) {
        final Function function = new Function(
                FUNC_RECUPERADATOBYUSUARIO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(usuario)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<String, String, String, String, String>> vectorResultados(BigInteger param0) {
        final Function function = new Function(FUNC_VECTORRESULTADOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple5<String, String, String, String, String>>(
                new Callable<Tuple5<String, String, String, String, String>>() {
                    @Override
                    public Tuple5<String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> entraDato(String usuario, String parcela, String tipo_dato, String dato, String fecha) {
        final Function function = new Function(
                FUNC_ENTRADATO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(usuario), 
                new org.web3j.abi.datatypes.Utf8String(parcela), 
                new org.web3j.abi.datatypes.Utf8String(tipo_dato), 
                new org.web3j.abi.datatypes.Utf8String(dato), 
                new org.web3j.abi.datatypes.Utf8String(fecha)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<String, String, String, String, String>> registros(BigInteger param0) {
        final Function function = new Function(FUNC_REGISTROS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple5<String, String, String, String, String>>(
                new Callable<Tuple5<String, String, String, String, String>>() {
                    @Override
                    public Tuple5<String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public static RemoteCall<Agrotente> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Agrotente.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Agrotente> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Agrotente.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Agrotente load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Agrotente(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Agrotente load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Agrotente(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
