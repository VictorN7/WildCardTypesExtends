# 🃏 WildcardsTypes em Java — `? extends T`

### ❓O que é:

Representa um tipo que é T ou qualquer subclasse de `T`.

### 💭Para que serve:

Usado quando você precisa ler/consumir dados de uma coleção de uma hierarquia de classes.
Garante que tudo que você ler será, no mínimo, do tipo `T` (ou uma subclasse).

### 🙋‍♂️Exemplo de uso:

Listas de Integer, Double, etc, tratadas como Number:

```java
List<? extends Number> numeros; // Integer, Double, etc
```

Quando o método consome dados de uma hierarquia:

```java
double somar(List<? extends Number> numeros) {
    double total = 0;
    for (Number n : numeros) {
        total += n.doubleValue();
    }
    return total;
}
```

### 📌 Resumo

- Aceita `T` ou qualquer subclasse de `T`
- Você pode ler como `T`
- Não pode adicionar valores
- Ideal quando você só consome dados

### ⚔️ `? extends T` vs outros wildcards

| Característica      | `? extends T`        | `? super T`           | `?`                  |
|--------------------|----------------------|-----------------------|----------------------|
| Pode ler           | ✅ Sim (como `T`)     | ✅ Sim (Object)        | ✅ Sim (Object)       |
| Pode adicionar     | ❌ Não               | ✅ Sim (`T`)           | ❌ Não                |
| Foco               | Leitura              | Escrita               | Leitura genérica      |
| Hierarquia         | Subclasses de `T`     | Superclasses de `T`   | Qualquer tipo         |
| Quando usar        | Consome dados         | Produz dados          | Tipo irrelevante      |
