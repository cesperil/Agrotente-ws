package es.cem.blockchain;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class App {
    

    public static void main(String[] args) throws Exception {
        new App().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/e4b14d8e9eff4e2c999fb156275bf648"));
        
    	//Web3j web3j = Web3j.build(new HttpService());
    	
        System.out.println("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "Esperilla1",
                        //"chaindata\\keystore\\UTC--2018-06-21T06-34-32.658490800Z--5ade9a7f8f57ab3995ac4d56c78a22649d3b1686");
                		"C:\\Users\\Carlos\\AppData\\Roaming\\Ethereum\\testnet\\keystore\\UTC--2019-02-13T21-17-05.070983700Z--a443e8582575dda22570412c7298b37a683de0e4");
        System.out.println("Credentials loaded");
        System.out.println("Sending Ether ..");
        
        switch ((int)web3j.web3ClientVersion().getId()) {
		case 1:
			System.out.println("Estamos en la main net");
			break;
		case 2:
			System.out.println("Estamos en la red ropsten");
			break;

		default:
			break;
		}
        
       
        	
        
        
       /* TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                //"0x19b4b496a4098e302106f62b875914f272713eee",  // you can put any address here
                "0xE9d2846c806435B6CF3492260159647aAd10f0a8", 
                BigDecimal.valueOf(1), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        System.out.println("Transaction complete : "
                + transferReceipt.getTransactionHash());
*/
       String account = web3j.ethAccounts().send().getAccounts().get(0);
       System.out.println("Cuenta: " + account);
       /*EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST)
    		   .sendAsync()
    		   .get();

       BigInteger wei = ethGetBalance.getBalance();
       System.out.println("Fondos de la cuenta " + wei);
       */
        // Now lets deploy a smart contract
        System.out.println("Deploying smart contract");
        BigInteger gas 		= Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();//new BigInteger("100");//Contract.GAS_PRICE;//new BigInteger("1");
        BigInteger gasLimit = new BigInteger("5000");//Contract.GAS_LIMIT;//new BigInteger("1");
       /* Helloworld contract = Helloworld.deploy(
                web3j, credentials,
                //gas, Contract.GAS_LIMIT).send();
                gas, gasLimit).send();

        String contractAddress = contract.getContractAddress();
        System.out.println("Smart contract deployed to address " + contractAddress);

        System.out.println("Initial value of counter in Smart contract: " + contract.getCounter().send());
        System.out.println("Incrementing counter in Smart contract");
        contract.add().send();
        System.out.println("Value of counter in Smart contract after increment : " + contract.getCounter().send());
        System.out.println("Decrementing counter in Smart contract");
        contract.subtract().send();
        System.out.println("Final value of counter in Smart contract : " + contract.getCounter().send());*/
        
        Agrotente contract = Agrotente.deploy(web3j, credentials, gas, gasLimit).send();
        String contractAddress = contract.getContractAddress();
        System.out.println("Smart contract deployed to address " + contractAddress);
        
        contract.entraDato("1", "1", "1", "1", "1").send();
        
        TransactionReceipt transaction = contract.recuperaDatoByUsuario("1").send();
        
        transaction.getBlockHash();
    }
}