__author__ = 'thomas'

import tkinter as tk

class Calculator(tk.Tk):
    num = 0.0
    def __init__(self):
        tk.Tk.__init__(self)
        self.answer = tk.Label(self)
        self.textArea = tk.Entry(self)
        self.addB = tk.Button(self, text="+", command=self.Add)
        self.subB = tk.Button(self, text="-", command=self.Sub)
        self.mulB = tk.Button(self, text="*", command=self.Mul)
        self.divB = tk.Button(self, text="/", command=self.Div)
        self.answer.grid( row=0, column=0, columnspan=5)
        self.textArea.grid(row=1, column=0, columnspan=5)
        self.addB.grid(row=2, column=0)
        self.subB.grid(row=2, column=1)
        self.mulB.grid(row=2, column=2)
        self.divB.grid(row=2, column=3)

    def Add(self):
        text = self.textArea.get()
        self.textArea.delete("0",len(text))
        text = float(text)
        self.num += text
        self.answer.configure(text="Ans: %f"%self.num)
    def Sub(self):
        text = self.textArea.get()
        self.textArea.delete("0",len(text))
        text = float(text)
        self.num -= text
        self.answer.configure(text="Ans: %f"%self.num)
    def Mul(self):
        text = self.textArea.get()
        self.textArea.delete("0",len(text))
        text = float(text)
        self.num *= text
        self.answer.configure(text="Ans: %f"%self.num)
    def Div(self):
        text = self.textArea.get()
        self.textArea.delete("0",len(text))
        text = float(text)
        self.num /= text
        self.answer.configure(text="Ans: %f"%self.num)



master = Calculator()
master.mainloop()


