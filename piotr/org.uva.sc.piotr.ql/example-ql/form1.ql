form taxOfficeExample
{
  "What is your name?"
    name: string
  "How old are you?"
    age: integer
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean

  if (!hasSoldHouse || hasBoughtHouse )
  {
    "What was the selling price?"
      sellingPrice: money
    "What is your name?"
      name: string
    "Private debts for the sold house:"
      privateDebt: money
    "Value residue:"
      valueResidue: money =
        (sellingPrice - privateDebt * 654)

  } else {

    if (name == "Piotr" && age == 32)
    {
      "What is the password?"
        password: string
    }

  }
}
