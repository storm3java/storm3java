Command Line Tools
==================

A storm3j fat jar is distributed with each release providing command line tools. The command line allow you to use some of the functionality of storm3j from your terminal:

These tools provide:

-   Wallet creation
-   Wallet password management
-   Ether transfer from one wallet to another
-   Generation of Solidity smart contract wrappers

The command line tools can be obtained as a zipfile/tarball from the [releases](https://github.com/storm3j/storm3j/releases/latest) page of the project repository, under the **Downloads** section, or for OS X users via [Homebrew](https://github.com/storm3j/homebrew-storm3j), or for Arch linux users via the [AUR](https://aur.archlinux.org/packages/storm3j/).

``` bash
brew tap storm3j/storm3j
brew install storm3j
```

To run via the zipfile, simply extract the zipfile and run the binary:

``` console
$ unzip storm3j-<version>.zip
   creating: storm3j-3.0.0/lib/
  inflating: storm3j-3.0.0/lib/core-1.0.2-all.jar
   creating: storm3j-3.0.0/bin/
  inflating: storm3j-3.0.0/bin/storm3j
  inflating: storm3j-3.0.0/bin/storm3j.bat
$ ./storm3j-<version>/bin/storm3j

              _      _____ _     _
             | |    |____ (_)   (_)
__      _____| |__      / /_     _   ___
\ \ /\ / / _ \ '_ \     \ \ |   | | / _ \
 \ V  V /  __/ |_) |.___/ / | _ | || (_) |
  \_/\_/ \___|_.__/ \____/| |(_)|_| \___/
                         _/ |
                        |__/

Usage: storm3j version|wallet|solidity ...
```

Wallet tools
------------

To generate a new Ethereum wallet:

``` bash
$ storm3j wallet create
```

To update the password for an existing wallet:

``` bash
$ storm3j wallet update <walletfile>
```

To send Ether to another address:

``` bash
$ storm3j wallet send <walletfile> 0x<address>|<ensName>
```

When sending Ether to another address you will be asked a series of questions before the transaction takes place. See the below for a full example

The following example demonstrates using storm3j to send Ether to another wallet.

``` console
$ ./storm3j-<version>/bin/storm3j wallet send <walletfile> 0x<address>|<ensName>

              _      _____ _     _
             | |    |____ (_)   (_)
__      _____| |__      / /_     _   ___
\ \ /\ / / _ \ '_ \     \ \ |   | | / _ \
 \ V  V /  __/ |_) |.___/ / | _ | || (_) |
  \_/\_/ \___|_.__/ \____/| |(_)|_| \___/
                         _/ |
                        |__/

Please enter your existing wallet file password:
Wallet for address 0x19e03255f667bdfd50a32722df860b1eeaf4d635 loaded
Please confirm address of running Ethereum client you wish to send the transfer request to [http://localhost:8545/]:
Connected successfully to client: Geth/v1.4.18-stable-c72f5459/darwin/go1.7.3
What amound would you like to transfer (please enter a numeric value): 0.000001
Please specify the unit (ether, wei, ...) [ether]:
Please confim that you wish to transfer 0.000001 ether (1000000000000 wei) to address 0x9c98e381edc5fe1ac514935f3cc3edaa764cf004
Please type 'yes' to proceed: yes
Commencing transfer (this may take a few minutes)...................................................................................................................$

Funds have been successfully transferred from 0x19e03255f667bdfd50a32722df860b1eeaf4d635 to 0x9c98e381edc5fe1ac514935f3cc3edaa764cf004
Transaction hash: 0xb00afc5c2bb92a76d03e17bd3a0175b80609e877cb124c02d19000d529390530
Mined block number: 1849039
```

Solidity smart contract wrapper generator
-----------------------------------------

Please refer to [Solidity smart contract wrappers](smart_contracts.md#solidity-smart-contract-wrappers).
