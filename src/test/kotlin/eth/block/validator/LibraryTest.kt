package eth.block.validator

import org.junit.jupiter.api.Test
import org.web3j.EVMTest
import org.web3j.NodeType
import org.web3j.counter.Counter
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.ContractGasProvider

@EVMTest(NodeType.GETH)
class LibraryTest {

    @Test
    fun test(web3j: Web3j, transactionManager: TransactionManager, gasProvider: ContractGasProvider) {
        val counter = Counter.deploy(web3j, transactionManager, gasProvider).send()
        val newValue = counter.increment().send()

        val bn = web3j.ethBlockNumber().send()
        val block = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(bn.blockNumber.toString()), true).send()
        val x = block.block
    }
}