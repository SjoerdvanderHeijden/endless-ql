form Box1HouseOwning {
   age: "What's your age?" integer
   if (!hasSoldHouse > 30 && hasBoughtHouse) {
      sellingPrice: "Price the house was sold for:" money
      privateDebt: "Private debts for the sold house:" money
      if (sellingPrice > -100) {
         bigQuestion: "What's your age?" string
      }
      valueResidue: "Value residue:" money(sellingPrice - privateDebt)
   } else {
      valueResidue: "Value residue:" integer(age - privateDebt)
   }
   name: "What is your name?" string
}